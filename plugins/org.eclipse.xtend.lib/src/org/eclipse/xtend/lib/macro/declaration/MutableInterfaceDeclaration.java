/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.declaration;

/**
 * 
 * @author Sven Efftinge
 */
public interface MutableInterfaceDeclaration extends MutableTypeDeclaration, InterfaceDeclaration {

	/**
	 * @param isStrictFloatingPoint
	 */
	void setStrictFloatingPoint(boolean isStrictFloatingPoint);

	/**
	 * @param superinterfaces the interfaces this class implements
	 */
	public void setExtendedInterfaces(Iterable<? extends TypeReference> superinterfaces);
}
