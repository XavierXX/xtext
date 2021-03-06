/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.resources

import com.google.inject.Inject
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.xbase.resource.XbaseResourceDescriptionStrategy
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.eclipse.xtext.resource.IResourceDescription
import org.junit.Test

class XbaseResourceDescriptionStrategyTest extends AbstractXbaseTestCase {
	
	@Inject XbaseResourceDescriptionStrategy descriptionStrategy
	
	@Inject IResourceDescription.Manager resourceDescriptionManager
	
	@Test def void testInterfaceDescription_01() {
		val interfaceType = TypesFactory::eINSTANCE.createJvmGenericType
		interfaceType.setInterface(true)
		interfaceType.setPackageName("foo")
		interfaceType.setSimpleName('MyType')
		val list = <IEObjectDescription>newArrayList()
		descriptionStrategy.createEObjectDescriptions(interfaceType, [ list += it ])
		assertTrue(list.exists[ "true" == getUserData(XbaseResourceDescriptionStrategy::IS_INTERFACE) ])
	}
	
	@Test def void testInterfaceDescription_02() {
		val interfaceType = TypesFactory::eINSTANCE.createJvmGenericType
		interfaceType.setInterface(false)
		interfaceType.setPackageName("foo")
		interfaceType.setSimpleName('MyType')
		val list = <IEObjectDescription>newArrayList()
		descriptionStrategy.createEObjectDescriptions(interfaceType, [ list += it ])
		assertFalse(list.exists[ "true" == getUserData(XbaseResourceDescriptionStrategy::IS_INTERFACE) ])
	}
	
	@Test def void testNoReferenceDescriptionsForPackageFragments() {
		val expression = expression('java::lang::String::valueOf("")')
		val resource = expression.eResource
		val description = resourceDescriptionManager.getResourceDescription(resource)
		val referenceDescriptions = description.referenceDescriptions.map[ targetEObjectUri.toString ].toSet
		assertEquals(2, referenceDescriptions.size)
		val expectation = #{ 
			'java:/Objects/java.lang.String#java.lang.String',
			'java:/Objects/java.lang.String#java.lang.String.valueOf(java.lang.Object)'
		}
		assertEquals(expectation, referenceDescriptions)
	}
}