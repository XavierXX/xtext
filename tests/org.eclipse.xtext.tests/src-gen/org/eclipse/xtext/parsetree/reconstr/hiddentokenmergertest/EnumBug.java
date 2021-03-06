/**
 */
package org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Bug</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.EnumBug#getReturn <em>Return</em>}</li>
 *   <li>{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.EnumBug#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.HiddentokenmergertestPackage#getEnumBug()
 * @model
 * @generated
 */
public interface EnumBug extends Model
{
  /**
   * Returns the value of the '<em><b>Return</b></em>' attribute.
   * The literals are from the enumeration {@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.EnumBugEnum}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Return</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Return</em>' attribute.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.EnumBugEnum
   * @see #setReturn(EnumBugEnum)
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.HiddentokenmergertestPackage#getEnumBug_Return()
   * @model
   * @generated
   */
  EnumBugEnum getReturn();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.EnumBug#getReturn <em>Return</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Return</em>' attribute.
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.EnumBugEnum
   * @see #getReturn()
   * @generated
   */
  void setReturn(EnumBugEnum value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.HiddentokenmergertestPackage#getEnumBug_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.xtext.parsetree.reconstr.hiddentokenmergertest.EnumBug#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // EnumBug
