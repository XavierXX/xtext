package org.eclipse.xtend.ide.tests.codebuilder;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.junit.Assert;

@SuppressWarnings("all")
public class AbstractBuilderTest extends AbstractXtendUITestCase {
  @Inject
  private WorkbenchTestHelper _workbenchTestHelper;
  
  @Inject
  private IXtendJvmAssociations _iXtendJvmAssociations;
  
  @Inject
  private TypeReferences _typeReferences;
  
  private JvmDeclaredType xtendClass;
  
  private JvmDeclaredType javaClass;
  
  protected JvmDeclaredType getXtendClass() {
    try {
      JvmDeclaredType _xblockexpression = null;
      {
        boolean _equals = ObjectExtensions.operator_equals(this.xtendClass, null);
        if (_equals) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("class Foo {");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
          XtendFile _xtendFile = this._workbenchTestHelper.xtendFile("Foo", _builder.toString());
          EList<XtendTypeDeclaration> _xtendTypes = _xtendFile.getXtendTypes();
          XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
          JvmGenericType _inferredType = this._iXtendJvmAssociations.getInferredType(((XtendClass) _head));
          this.xtendClass = _inferredType;
        }
        _xblockexpression = (this.xtendClass);
      }
      return _xblockexpression;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected JvmDeclaredType getJavaClass() {
    try {
      JvmDeclaredType _xblockexpression = null;
      {
        boolean _equals = ObjectExtensions.operator_equals(this.javaClass, null);
        if (_equals) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("public class Bar {");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
          this._workbenchTestHelper.createFile("Bar.java", _builder.toString());
          IResourcesSetupUtil.waitForAutoBuild();
          JvmDeclaredType _xtendClass = this.getXtendClass();
          JvmTypeReference _typeForName = this._typeReferences.getTypeForName("Bar", _xtendClass);
          JvmType _type = _typeForName.getType();
          this.javaClass = ((JvmDeclaredType) _type);
        }
        _xblockexpression = (this.javaClass);
      }
      return _xblockexpression;
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void assertBuilds(final ICodeBuilder builder, final String expectedCode) {
    boolean _isValid = builder.isValid();
    Assert.assertTrue(_isValid);
    StringBuilderBasedAppendable _stringBuilderBasedAppendable = new StringBuilderBasedAppendable();
    final StringBuilderBasedAppendable appendable = _stringBuilderBasedAppendable;
    builder.build(appendable);
    String _string = appendable.toString();
    Assert.assertEquals(expectedCode, _string);
  }
}