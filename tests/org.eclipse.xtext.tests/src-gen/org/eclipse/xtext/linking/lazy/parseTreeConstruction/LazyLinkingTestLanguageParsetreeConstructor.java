/*
* generated by Xtext
*/
package org.eclipse.xtext.linking.lazy.parseTreeConstruction;

import org.eclipse.emf.ecore.*;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parsetree.reconstr.IEObjectConsumer;

import org.eclipse.xtext.linking.lazy.services.LazyLinkingTestLanguageGrammarAccess;

import com.google.inject.Inject;

@SuppressWarnings("all")
public class LazyLinkingTestLanguageParsetreeConstructor extends org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor {
		
	@Inject
	private LazyLinkingTestLanguageGrammarAccess grammarAccess;
	
	@Override
	protected AbstractToken getRootToken(IEObjectConsumer inst) {
		return new ThisRootNode(inst);	
	}
	
protected class ThisRootNode extends RootToken {
	public ThisRootNode(IEObjectConsumer inst) {
		super(inst);
	}
	
	@Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Model_TypesAssignment(this, this, 0, inst);
			case 1: return new Type_Group(this, this, 1, inst);
			case 2: return new Property_Group(this, this, 2, inst);
			case 3: return new UnresolvedProxyProperty_Group(this, this, 3, inst);
			default: return null;
		}	
	}	
}
	

/************ begin Rule Model ****************
 *
 * Model:
 * 	types+=Type*;
 *
 **/

// types+=Type*
protected class Model_TypesAssignment extends AssignmentToken  {
	
	public Model_TypesAssignment(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getModelAccess().getTypesAssignment();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Type_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("types",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("types");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTypeRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getModelAccess().getTypesTypeParserRuleCall_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Model_TypesAssignment(lastRuleCallOrigin, next, actIndex, consumed);
			default: return lastRuleCallOrigin.createFollowerAfterReturn(next, actIndex , index - 1, consumed);
		}	
	}	
}

/************ end Rule Model ****************/


/************ begin Rule Type ****************
 *
 * Type:
 * 	"type" name=ID ("extends" extends=[Type] "." parentId=[Property])? ("for" parentId=[Property] "in" extends=[Type])?
 * 	"{" properties+=Property* unresolvedProxyProperty+=UnresolvedProxyProperty* "}";
 *
 **/

// "type" name=ID ("extends" extends=[Type] "." parentId=[Property])? ("for" parentId=[Property] "in" extends=[Type])? "{"
// properties+=Property* unresolvedProxyProperty+=UnresolvedProxyProperty* "}"
protected class Type_Group extends GroupToken {
	
	public Type_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTypeAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Type_RightCurlyBracketKeyword_7(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getTypeRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "type"
protected class Type_TypeKeyword_0 extends KeywordToken  {
	
	public Type_TypeKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTypeAccess().getTypeKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// name=ID
protected class Type_NameAssignment_1 extends AssignmentToken  {
	
	public Type_NameAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTypeAccess().getNameAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Type_TypeKeyword_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("name",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("name");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getTypeAccess().getNameIDTerminalRuleCall_1_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getTypeAccess().getNameIDTerminalRuleCall_1_0();
			return obj;
		}
		return null;
	}

}

// ("extends" extends=[Type] "." parentId=[Property])?
protected class Type_Group_2 extends GroupToken {
	
	public Type_Group_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTypeAccess().getGroup_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Type_ParentIdAssignment_2_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "extends"
protected class Type_ExtendsKeyword_2_0 extends KeywordToken  {
	
	public Type_ExtendsKeyword_2_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTypeAccess().getExtendsKeyword_2_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Type_NameAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// extends=[Type]
protected class Type_ExtendsAssignment_2_1 extends AssignmentToken  {
	
	public Type_ExtendsAssignment_2_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTypeAccess().getExtendsAssignment_2_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Type_ExtendsKeyword_2_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("extends",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("extends");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::CrossReferenceImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTypeAccess().getExtendsTypeCrossReference_2_1_0().getType().getClassifier())) {
				type = AssignmentType.CROSS_REFERENCE;
				element = grammarAccess.getTypeAccess().getExtendsTypeCrossReference_2_1_0(); 
				return obj;
			}
		}
		return null;
	}

}

// "."
protected class Type_FullStopKeyword_2_2 extends KeywordToken  {
	
	public Type_FullStopKeyword_2_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTypeAccess().getFullStopKeyword_2_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Type_ExtendsAssignment_2_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// parentId=[Property]
protected class Type_ParentIdAssignment_2_3 extends AssignmentToken  {
	
	public Type_ParentIdAssignment_2_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTypeAccess().getParentIdAssignment_2_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Type_FullStopKeyword_2_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("parentId",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("parentId");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::CrossReferenceImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTypeAccess().getParentIdPropertyCrossReference_2_3_0().getType().getClassifier())) {
				type = AssignmentType.CROSS_REFERENCE;
				element = grammarAccess.getTypeAccess().getParentIdPropertyCrossReference_2_3_0(); 
				return obj;
			}
		}
		return null;
	}

}


// ("for" parentId=[Property] "in" extends=[Type])?
protected class Type_Group_3 extends GroupToken {
	
	public Type_Group_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getTypeAccess().getGroup_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Type_ExtendsAssignment_3_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// "for"
protected class Type_ForKeyword_3_0 extends KeywordToken  {
	
	public Type_ForKeyword_3_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTypeAccess().getForKeyword_3_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Type_Group_2(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Type_NameAssignment_1(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

}

// parentId=[Property]
protected class Type_ParentIdAssignment_3_1 extends AssignmentToken  {
	
	public Type_ParentIdAssignment_3_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTypeAccess().getParentIdAssignment_3_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Type_ForKeyword_3_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("parentId",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("parentId");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::CrossReferenceImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTypeAccess().getParentIdPropertyCrossReference_3_1_0().getType().getClassifier())) {
				type = AssignmentType.CROSS_REFERENCE;
				element = grammarAccess.getTypeAccess().getParentIdPropertyCrossReference_3_1_0(); 
				return obj;
			}
		}
		return null;
	}

}

// "in"
protected class Type_InKeyword_3_2 extends KeywordToken  {
	
	public Type_InKeyword_3_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTypeAccess().getInKeyword_3_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Type_ParentIdAssignment_3_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}

// extends=[Type]
protected class Type_ExtendsAssignment_3_3 extends AssignmentToken  {
	
	public Type_ExtendsAssignment_3_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTypeAccess().getExtendsAssignment_3_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Type_InKeyword_3_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("extends",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("extends");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::CrossReferenceImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getTypeAccess().getExtendsTypeCrossReference_3_3_0().getType().getClassifier())) {
				type = AssignmentType.CROSS_REFERENCE;
				element = grammarAccess.getTypeAccess().getExtendsTypeCrossReference_3_3_0(); 
				return obj;
			}
		}
		return null;
	}

}


// "{"
protected class Type_LeftCurlyBracketKeyword_4 extends KeywordToken  {
	
	public Type_LeftCurlyBracketKeyword_4(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTypeAccess().getLeftCurlyBracketKeyword_4();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Type_Group_3(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Type_Group_2(lastRuleCallOrigin, this, 1, inst);
			case 2: return new Type_NameAssignment_1(lastRuleCallOrigin, this, 2, inst);
			default: return null;
		}	
	}

}

// properties+=Property*
protected class Type_PropertiesAssignment_5 extends AssignmentToken  {
	
	public Type_PropertiesAssignment_5(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTypeAccess().getPropertiesAssignment_5();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Property_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("properties",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("properties");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getPropertyRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getTypeAccess().getPropertiesPropertyParserRuleCall_5_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Type_PropertiesAssignment_5(lastRuleCallOrigin, next, actIndex, consumed);
			case 1: return new Type_LeftCurlyBracketKeyword_4(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// unresolvedProxyProperty+=UnresolvedProxyProperty*
protected class Type_UnresolvedProxyPropertyAssignment_6 extends AssignmentToken  {
	
	public Type_UnresolvedProxyPropertyAssignment_6(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getTypeAccess().getUnresolvedProxyPropertyAssignment_6();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new UnresolvedProxyProperty_Group(this, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("unresolvedProxyProperty",false)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("unresolvedProxyProperty");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::RuleCallImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getUnresolvedProxyPropertyRule().getType().getClassifier())) {
				type = AssignmentType.PARSER_RULE_CALL;
				element = grammarAccess.getTypeAccess().getUnresolvedProxyPropertyUnresolvedProxyPropertyParserRuleCall_6_0(); 
				consumed = obj;
				return param;
			}
		}
		return null;
	}

    @Override
	public AbstractToken createFollowerAfterReturn(AbstractToken next,	int actIndex, int index, IEObjectConsumer inst) {
		if(value == inst.getEObject() && !inst.isConsumed()) return null;
		switch(index) {
			case 0: return new Type_UnresolvedProxyPropertyAssignment_6(lastRuleCallOrigin, next, actIndex, consumed);
			case 1: return new Type_PropertiesAssignment_5(lastRuleCallOrigin, next, actIndex, consumed);
			case 2: return new Type_LeftCurlyBracketKeyword_4(lastRuleCallOrigin, next, actIndex, consumed);
			default: return null;
		}	
	}	
}

// "}"
protected class Type_RightCurlyBracketKeyword_7 extends KeywordToken  {
	
	public Type_RightCurlyBracketKeyword_7(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getTypeAccess().getRightCurlyBracketKeyword_7();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Type_UnresolvedProxyPropertyAssignment_6(lastRuleCallOrigin, this, 0, inst);
			case 1: return new Type_PropertiesAssignment_5(lastRuleCallOrigin, this, 1, inst);
			case 2: return new Type_LeftCurlyBracketKeyword_4(lastRuleCallOrigin, this, 2, inst);
			default: return null;
		}	
	}

}


/************ end Rule Type ****************/


/************ begin Rule Property ****************
 *
 * Property:
 * 	type+=[Type]+ name=ID ";";
 *
 **/

// type+=[Type]+ name=ID ";"
protected class Property_Group extends GroupToken {
	
	public Property_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getPropertyAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Property_SemicolonKeyword_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getPropertyRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// type+=[Type]+
protected class Property_TypeAssignment_0 extends AssignmentToken  {
	
	public Property_TypeAssignment_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getPropertyAccess().getTypeAssignment_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Property_TypeAssignment_0(lastRuleCallOrigin, this, 0, inst);
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index - 1, inst);
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("type",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("type");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::CrossReferenceImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getPropertyAccess().getTypeTypeCrossReference_0_0().getType().getClassifier())) {
				type = AssignmentType.CROSS_REFERENCE;
				element = grammarAccess.getPropertyAccess().getTypeTypeCrossReference_0_0(); 
				return obj;
			}
		}
		return null;
	}

}

// name=ID
protected class Property_NameAssignment_1 extends AssignmentToken  {
	
	public Property_NameAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getPropertyAccess().getNameAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Property_TypeAssignment_0(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("name",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("name");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_1_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_1_0();
			return obj;
		}
		return null;
	}

}

// ";"
protected class Property_SemicolonKeyword_2 extends KeywordToken  {
	
	public Property_SemicolonKeyword_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getPropertyAccess().getSemicolonKeyword_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new Property_NameAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}


/************ end Rule Property ****************/


/************ begin Rule UnresolvedProxyProperty ****************
 *
 * UnresolvedProxyProperty:
 * 	"unresolved" type+=[Type]+ name=ID ";";
 *
 **/

// "unresolved" type+=[Type]+ name=ID ";"
protected class UnresolvedProxyProperty_Group extends GroupToken {
	
	public UnresolvedProxyProperty_Group(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Group getGrammarElement() {
		return grammarAccess.getUnresolvedProxyPropertyAccess().getGroup();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new UnresolvedProxyProperty_SemicolonKeyword_3(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override
	public IEObjectConsumer tryConsume() {
		if(getEObject().eClass() != grammarAccess.getUnresolvedProxyPropertyRule().getType().getClassifier())
			return null;
		return eObjectConsumer;
	}

}

// "unresolved"
protected class UnresolvedProxyProperty_UnresolvedKeyword_0 extends KeywordToken  {
	
	public UnresolvedProxyProperty_UnresolvedKeyword_0(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getUnresolvedProxyPropertyAccess().getUnresolvedKeyword_0();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			default: return lastRuleCallOrigin.createFollowerAfterReturn(this, index, index, inst);
		}	
	}

}

// type+=[Type]+
protected class UnresolvedProxyProperty_TypeAssignment_1 extends AssignmentToken  {
	
	public UnresolvedProxyProperty_TypeAssignment_1(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getUnresolvedProxyPropertyAccess().getTypeAssignment_1();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new UnresolvedProxyProperty_TypeAssignment_1(lastRuleCallOrigin, this, 0, inst);
			case 1: return new UnresolvedProxyProperty_UnresolvedKeyword_0(lastRuleCallOrigin, this, 1, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("type",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("type");
		if(value instanceof EObject) { // org::eclipse::xtext::impl::CrossReferenceImpl
			IEObjectConsumer param = createEObjectConsumer((EObject)value);
			if(param.isInstanceOf(grammarAccess.getUnresolvedProxyPropertyAccess().getTypeTypeCrossReference_1_0().getType().getClassifier())) {
				type = AssignmentType.CROSS_REFERENCE;
				element = grammarAccess.getUnresolvedProxyPropertyAccess().getTypeTypeCrossReference_1_0(); 
				return obj;
			}
		}
		return null;
	}

}

// name=ID
protected class UnresolvedProxyProperty_NameAssignment_2 extends AssignmentToken  {
	
	public UnresolvedProxyProperty_NameAssignment_2(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Assignment getGrammarElement() {
		return grammarAccess.getUnresolvedProxyPropertyAccess().getNameAssignment_2();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new UnresolvedProxyProperty_TypeAssignment_1(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

    @Override	
	public IEObjectConsumer tryConsume() {
		if((value = eObjectConsumer.getConsumable("name",true)) == null) return null;
		IEObjectConsumer obj = eObjectConsumer.cloneAndConsume("name");
		if(valueSerializer.isValid(obj.getEObject(), grammarAccess.getUnresolvedProxyPropertyAccess().getNameIDTerminalRuleCall_2_0(), value, null)) {
			type = AssignmentType.TERMINAL_RULE_CALL;
			element = grammarAccess.getUnresolvedProxyPropertyAccess().getNameIDTerminalRuleCall_2_0();
			return obj;
		}
		return null;
	}

}

// ";"
protected class UnresolvedProxyProperty_SemicolonKeyword_3 extends KeywordToken  {
	
	public UnresolvedProxyProperty_SemicolonKeyword_3(AbstractToken lastRuleCallOrigin, AbstractToken next, int transitionIndex, IEObjectConsumer eObjectConsumer) {
		super(lastRuleCallOrigin, next, transitionIndex, eObjectConsumer);
	}
	
	@Override
	public Keyword getGrammarElement() {
		return grammarAccess.getUnresolvedProxyPropertyAccess().getSemicolonKeyword_3();
	}

    @Override
	public AbstractToken createFollower(int index, IEObjectConsumer inst) {
		switch(index) {
			case 0: return new UnresolvedProxyProperty_NameAssignment_2(lastRuleCallOrigin, this, 0, inst);
			default: return null;
		}	
	}

}


/************ end Rule UnresolvedProxyProperty ****************/

}
