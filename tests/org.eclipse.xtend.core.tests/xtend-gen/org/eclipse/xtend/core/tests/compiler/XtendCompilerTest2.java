/**
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.compiler;

import org.eclipse.xtend.core.tests.NewTypeSystemRuntimeInjectorProvider;
import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(value = XtextRunner.class)
@InjectWith(value = NewTypeSystemRuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class XtendCompilerTest2 extends AbstractXtendCompilerTest {
  @Test
  @Ignore(value = "TODO")
  public void testReturnType() {
    super.testReturnType();
  }
  
  @Test
  @Ignore(value = "TODO")
  public void testReturnType_02() {
    super.testReturnType_02();
  }
  
  @Test
  @Ignore(value = "TODO implement better expectation computation for unresolved type parameters")
  public void testRichStringAutoConversionToString_02() {
    Assert.fail("TODO implement better expectation computation for unresolved type parameters");
  }
  
  @Test
  public void testBug380062_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class Foo<T> {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def Object foo(Foo ^new) {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("foo(^new)");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo<T extends Object> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Object foo(final Foo new_) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Object _foo = this.foo(new_);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _foo;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testExplicitBoxingUnboxing() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class X {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def Object foo(int p0, Integer p1) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("foo(p1,p0)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class X {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Object foo(final int p0, final Integer p1) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Object _foo = this.foo((p1).intValue(), Integer.valueOf(p0));");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _foo;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testThreeDataClassesExtendingEachOther() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.ArrayList");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Data class Node {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("ArrayList<Node> contents = newArrayList");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def String tagName() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("getClass.simpleName.toLowerCase");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("@Data class ContentNode extends Node {}");
    _builder.newLine();
    _builder.append("@Data class Body extends ContentNode {}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import java.util.ArrayList;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtend.lib.Data;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.CollectionLiterals;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Functions.Function0;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.util.ToStringHelper;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@Data");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Node {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private final ArrayList<Node> _contents = new Function0<ArrayList<Node>>() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("public ArrayList<Node> apply() {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("ArrayList<Node> _newArrayList = CollectionLiterals.<Node>newArrayList();");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return _newArrayList;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}.apply();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public ArrayList<Node> getContents() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this._contents;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String tagName() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Class<? extends Node> _class = this.getClass();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("String _simpleName = _class.getSimpleName();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("String _lowerCase = _simpleName.toLowerCase();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _lowerCase;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Node() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("super();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public int hashCode() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final int prime = 31;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("int result = 1;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("result = prime * result + ((_contents== null) ? 0 : _contents.hashCode());");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return result;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public boolean equals(final Object obj) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (this == obj)");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return true;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (obj == null)");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (getClass() != obj.getClass())");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Node other = (Node) obj;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (_contents == null) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("if (other._contents != null)");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("return false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else if (!_contents.equals(other._contents))");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return true;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String toString() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("String result = new ToStringHelper().toString(this);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return result;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testSwitchOverNull() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class Foo  {");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("def foo() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("switch null {");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("case null : [Object it|it]");
    _builder.newLine();
    _builder.append("            ");
    _builder.append("case null : [Integer it|it]");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("}    ");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import com.google.common.base.Objects;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Functions.Function1;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Function1<? super Integer,? extends Object> foo() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Function1<? super Integer,? extends Object> _switchResult = null;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final Object _switchValue = null;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("boolean _matched = false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (!_matched) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("if (Objects.equal(_switchValue,null)) {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("_matched=true;");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("final Function1<Object,Object> _function = new Function1<Object,Object>() {");
    _builder_1.newLine();
    _builder_1.append("            ");
    _builder_1.append("public Object apply(final Object it) {");
    _builder_1.newLine();
    _builder_1.append("              ");
    _builder_1.append("return it;");
    _builder_1.newLine();
    _builder_1.append("            ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("_switchResult = _function;");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (!_matched) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("if (Objects.equal(_switchValue,null)) {");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("_matched=true;");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("final Function1<Integer,Integer> _function_1 = new Function1<Integer,Integer>() {");
    _builder_1.newLine();
    _builder_1.append("            ");
    _builder_1.append("public Integer apply(final Integer it) {");
    _builder_1.newLine();
    _builder_1.append("              ");
    _builder_1.append("return it;");
    _builder_1.newLine();
    _builder_1.append("            ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("          ");
    _builder_1.append("};");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("_switchResult = _function_1;");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return _switchResult;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
}