/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler.output;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.output.TreeAppendable;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TreeAppendableTest extends Assert implements ILocationInFileProvider {

	private Iterator<ITextRegion> expectedRegions;
	private EClass content;
	private Resource resource;

	public ITextRegion getSignificantTextRegion(EObject obj) {
		return expectedRegions.next();
	}

	public ITextRegion getSignificantTextRegion(EObject owner, EStructuralFeature feature, int indexInList) {
		throw new UnsupportedOperationException();
	}

	public ITextRegion getFullTextRegion(EObject obj) {
		throw new UnsupportedOperationException();
	}

	public ITextRegion getFullTextRegion(EObject owner, EStructuralFeature feature, int indexInList) {
		throw new UnsupportedOperationException();
	}

	@Before
	public void createResource() {
		content = EcoreFactory.eINSTANCE.createEClass();
		resource = new ResourceImpl(URI.createURI("platform:/resource/test"));
		resource.getContents().add(content);
	}
	
	@After
	public void clearFields() {
		content = null;
		resource = null;
		if (expectedRegions != null) {
			assertFalse(expectedRegions.hasNext());
		}
	}
	
	@Test
	public void testEmpty() {
		expectedRegions = Collections.<ITextRegion>singleton(new TextRegion(47, 11)).iterator();
		TreeAppendable appendable = new TreeAppendable(new ImportManager(false), this, content, "  ", "\n");
		assertEquals("", appendable.getContent());
		AbstractTraceRegion traceRegion = appendable.getTraceRegion();
		assertNotNull(traceRegion);
		assertEquals(47, traceRegion.getToOffset());
		assertEquals(11, traceRegion.getToLength());
		assertEquals(resource.getURI(), traceRegion.getToPath());
		assertEquals("test", traceRegion.getToProjectName());
		assertTrue(traceRegion.getNestedRegions().isEmpty());
	}
	
	@Test
	public void testNoRedundantRegions() {
		ITextRegion redundant = new TextRegion(47, 11);
		ITextRegion second = new TextRegion(8, 15);
		expectedRegions = Arrays.asList(redundant, redundant, second).iterator();
		TreeAppendable appendable = new TreeAppendable(new ImportManager(false), this, content, "  ", "\n");
		appendable.append("initial");
		appendable.trace(content).append("first");
		appendable.trace(content).append("second");
		assertEquals("initialfirstsecond", appendable.getContent());
		AbstractTraceRegion traceRegion = appendable.getTraceRegion();
		assertNotNull(traceRegion);
		assertEquals(47, traceRegion.getToOffset());
		assertEquals(11, traceRegion.getToLength());
		assertEquals(0, traceRegion.getFromOffset());
		assertEquals("initialfirstsecond".length(), traceRegion.getFromLength());
		List<AbstractTraceRegion> nestedRegions = traceRegion.getNestedRegions();
		assertEquals(1, nestedRegions.size());
		AbstractTraceRegion child = nestedRegions.get(0);
		assertEquals(8, child.getToOffset());
		assertEquals(15, child.getToLength());
		assertEquals("initialfirst".length(), child.getFromOffset());
		assertEquals("second".length(), child.getFromLength());
	}
	
	@Test
	public void testNoEmptyLeafs() {
		ITextRegion root = new TextRegion(47, 11);
		ITextRegion emptyChild = new TextRegion(8, 15);
		ITextRegion emptyGrandChild = new TextRegion(123, 321);
		expectedRegions = Arrays.asList(root, emptyChild, emptyGrandChild).iterator();
		TreeAppendable appendable = new TreeAppendable(new ImportManager(false), this, content, "  ", "\n");
		appendable.append("initial");
		appendable.trace(content).trace(content);
		appendable.append("end");
		assertEquals("initialend", appendable.getContent());
		AbstractTraceRegion traceRegion = appendable.getTraceRegion();
		assertTrue(traceRegion.getNestedRegions().isEmpty());
	}
	
	@Test
	public void testIntermediatesMayBeEmpty() {
		ITextRegion root = new TextRegion(47, 11);
		ITextRegion emptyChild = new TextRegion(8, 15);
		ITextRegion emptyGrandChild = new TextRegion(123, 321);
		expectedRegions = Arrays.asList(root, emptyChild, emptyGrandChild).iterator();
		TreeAppendable appendable = new TreeAppendable(new ImportManager(false), this, content, "  ", "\n");
		appendable.trace(content).trace(content).append("text");
		assertEquals("text", appendable.getContent());
		AbstractTraceRegion traceRegion = appendable.getTraceRegion();
		assertEquals(1, traceRegion.getNestedRegions().size());
		AbstractTraceRegion child = traceRegion.getNestedRegions().get(0);
		assertEquals(1, child.getNestedRegions().size());
		AbstractTraceRegion grandChild = child.getNestedRegions().get(0);
		assertTrue(grandChild.getNestedRegions().isEmpty());
		assertEquals(0, grandChild.getFromOffset());
		assertEquals(4, grandChild.getFromLength());
		assertEquals(123, grandChild.getToOffset());
		assertEquals(321, grandChild.getToLength());
	}
	
	@Test
	public void testInsertionIsProhibited() {
		ITextRegion root = new TextRegion(47, 11);
		ITextRegion child = new TextRegion(8, 15);
		expectedRegions = Arrays.asList(root, child).iterator();
		TreeAppendable appendable = new TreeAppendable(new ImportManager(false), this, content, "  ", "\n");
		TreeAppendable traced = appendable.trace(content);
		appendable.append("test");
		// don't use @Test(expected=..) since we want to be sure about the cause
		try {
			traced.append("insertion");
			fail("Expected IllegalStateException");
		} catch(IllegalStateException e) {
			// expected
		}
	}
	
	@Test
	public void tesUnsafeInsertionIsOk() {
		ITextRegion root = new TextRegion(47, 11);
		ITextRegion child = new TextRegion(8, 15);
		expectedRegions = Arrays.asList(root, child).iterator();
		TreeAppendable appendable = new TreeAppendable(new ImportManager(false), this, content, "  ", "\n");
		TreeAppendable traced = appendable.trace(content);
		appendable.append("test");
		traced.appendUnsafe("insertion");
		assertEquals("insertiontest", appendable.getContent());
	}
	
	@Test
	public void testNewlineIndents() {
		expectedRegions = Collections.<ITextRegion>singleton(ITextRegion.EMPTY_REGION).iterator();
		TreeAppendable appendable = new TreeAppendable(new ImportManager(false), this, content, "aa", "bb");
		assertEquals("bb", appendable.newLine().getContent());
		appendable.increaseIndentation();
		assertEquals("bbbbaa", appendable.newLine().getContent());
		appendable.decreaseIndentation();
		assertEquals("bbbbaabb", appendable.newLine().getContent());
	}

	@Test
	public void testAppendedTextIsIndented() {
		expectedRegions = Collections.<ITextRegion>singleton(ITextRegion.EMPTY_REGION).iterator();
		TreeAppendable appendable = new TreeAppendable(new ImportManager(false), this, content, "aa", "bb");
		appendable.increaseIndentation();
		appendable.append("my \n text \r more \r\n end");
		assertEquals("my bbaa text bbaa more bbaa end", appendable.getContent());
	}
	
}