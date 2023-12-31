// generated with ast extension for cup
// version 0.8
// 27/5/2023 11:17:38


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(ConstDeclListComma ConstDeclListComma);
    public void visit(StatementLine StatementLine);
    public void visit(StatementPrintOpt StatementPrintOpt);
    public void visit(FactorMatrix FactorMatrix);
    public void visit(ActParsOpt ActParsOpt);
    public void visit(TermList TermList);
    public void visit(StatementReturnOpt StatementReturnOpt);
    public void visit(DesignatorSemi DesignatorSemi);
    public void visit(ConditionList ConditionList);
    public void visit(FactorPars FactorPars);
    public void visit(OptArray OptArray);
    public void visit(DesignatorOpt DesignatorOpt);
    public void visit(VarDeclComma VarDeclComma);
    public void visit(StatementList StatementList);
    public void visit(DecLine DecLine);
    public void visit(Factor Factor);
    public void visit(CondFactList CondFactList);
    public void visit(DeclList DeclList);
    public void visit(RetType RetType);
    public void visit(MulOp MulOp);
    public void visit(DesignatorStatementOpt DesignatorStatementOpt);
    public void visit(ConstDeclList ConstDeclList);
    public void visit(ActParsList ActParsList);
    public void visit(DashOpt DashOpt);
    public void visit(DesignatorStatementList DesignatorStatementList);
    public void visit(Literals Literals);
    public void visit(RelOp RelOp);
    public void visit(AssignOp AssignOp);
    public void visit(ExprList ExprList);
    public void visit(FactorDesignatorOpt FactorDesignatorOpt);
    public void visit(FormParsMore FormParsMore);
    public void visit(VarDeclList VarDeclList);
    public void visit(ConstVal ConstVal);
    public void visit(StatementElseOpt StatementElseOpt);
    public void visit(DesignatorList DesignatorList);
    public void visit(AddOp AddOp);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(Statement Statement);
    public void visit(CondFactOpt CondFactOpt);
    public void visit(MethodVarDeclList MethodVarDeclList);
    public void visit(FormPars FormPars);
    public void visit(Label Label);
    public void visit(AssignOpNoErr AssignOpNoErr);
    public void visit(RelOpELesser RelOpELesser);
    public void visit(RelOpLesser RelOpLesser);
    public void visit(RelOpEGreater RelOpEGreater);
    public void visit(RelOpGreater RelOpGreater);
    public void visit(RelOpDifferent RelOpDifferent);
    public void visit(RelOpEqualSame RelOpEqualSame);
    public void visit(MulOpMod MulOpMod);
    public void visit(MulOpDiv MulOpDiv);
    public void visit(MulOpMul MulOpMul);
    public void visit(AddOpMinus AddOpMinus);
    public void visit(AddOpPlus AddOpPlus);
    public void visit(ActParsListEpsilon ActParsListEpsilon);
    public void visit(ActParsListRec ActParsListRec);
    public void visit(ActPars ActPars);
    public void visit(DashOptLambda DashOptLambda);
    public void visit(DashOptSingle DashOptSingle);
    public void visit(ActParsOptEpsilon ActParsOptEpsilon);
    public void visit(ActParsOptSingle ActParsOptSingle);
    public void visit(FactorParsActPars FactorParsActPars);
    public void visit(FactorParsExpr FactorParsExpr);
    public void visit(FactorDesignatorOptEpsilon FactorDesignatorOptEpsilon);
    public void visit(FactorDesignatorOptSingle FactorDesignatorOptSingle);
    public void visit(LiteralsBoolean LiteralsBoolean);
    public void visit(LiteralsChar LiteralsChar);
    public void visit(LiteralsNum LiteralsNum);
    public void visit(FactorNewType FactorNewType);
    public void visit(FactorMatrixEpsilon FactorMatrixEpsilon);
    public void visit(FactorMatrixSingle FactorMatrixSingle);
    public void visit(FactorRec FactorRec);
    public void visit(FactorNew FactorNew);
    public void visit(FactorLiterals FactorLiterals);
    public void visit(FactorDesignator FactorDesignator);
    public void visit(TermListEpsilon TermListEpsilon);
    public void visit(TermListRec TermListRec);
    public void visit(Term Term);
    public void visit(ExprListEpsilon ExprListEpsilon);
    public void visit(ExprListSingle ExprListSingle);
    public void visit(Expr Expr);
    public void visit(CondFactOptLambda CondFactOptLambda);
    public void visit(CondFactOptSingle CondFactOptSingle);
    public void visit(CondFact CondFact);
    public void visit(CondFacrListEpsilon CondFacrListEpsilon);
    public void visit(CondFactListRec CondFactListRec);
    public void visit(CondTerm CondTerm);
    public void visit(ConditionListSigma ConditionListSigma);
    public void visit(ConditionListRec ConditionListRec);
    public void visit(Condition Condition);
    public void visit(DesignatorListEpsilon DesignatorListEpsilon);
    public void visit(DesignatorListDesignator DesignatorListDesignator);
    public void visit(Designator Designator);
    public void visit(DesignatorStatementOptDecrement DesignatorStatementOptDecrement);
    public void visit(DesignatorStatementOptIncrement DesignatorStatementOptIncrement);
    public void visit(DesignatorStatementOptActPars DesignatorStatementOptActPars);
    public void visit(DesignatorStatementOptAssign DesignatorStatementOptAssign);
    public void visit(DesignatorStatementEpsilon DesignatorStatementEpsilon);
    public void visit(DesignatorStatementListRec DesignatorStatementListRec);
    public void visit(DesignatorOptEpsilon DesignatorOptEpsilon);
    public void visit(DesignatorOptSingle DesignatorOptSingle);
    public void visit(DesignatorStatementOpt2 DesignatorStatementOpt2);
    public void visit(DesignatorStatementOpt1 DesignatorStatementOpt1);
    public void visit(DesignatorSemiDerived1 DesignatorSemiDerived1);
    public void visit(DesignatorSemiStatement DesignatorSemiStatement);
    public void visit(StatementPrintOptEpsilon StatementPrintOptEpsilon);
    public void visit(StatementPrintOptSingle StatementPrintOptSingle);
    public void visit(StatementReturnOptEpsilon StatementReturnOptEpsilon);
    public void visit(StatementReturnOptSingle StatementReturnOptSingle);
    public void visit(StatementListEpsilon StatementListEpsilon);
    public void visit(StatementListRec StatementListRec);
    public void visit(StatementElseOptEpsilon StatementElseOptEpsilon);
    public void visit(StatementElseOptSingle StatementElseOptSingle);
    public void visit(StatementBraces StatementBraces);
    public void visit(StatementPrint StatementPrint);
    public void visit(StatementRead StatementRead);
    public void visit(StatementReturn StatementReturn);
    public void visit(StatementContinue StatementContinue);
    public void visit(StatementBreak StatementBreak);
    public void visit(StatementWhile StatementWhile);
    public void visit(StatementIf StatementIf);
    public void visit(StatementDesignator StatementDesignator);
    public void visit(StatementLineEpsilon StatementLineEpsilon);
    public void visit(StatementLineRec StatementLineRec);
    public void visit(MethodVarDeclLine MethodVarDeclLine);
    public void visit(MethodVarDeclListEpsilon MethodVarDeclListEpsilon);
    public void visit(MethodVarDeclListRec MethodVarDeclListRec);
    public void visit(FormParsMoreEpsilon FormParsMoreEpsilon);
    public void visit(FormParsMoreSingle FormParsMoreSingle);
    public void visit(FormParsList FormParsList);
    public void visit(FormParsEpsilon FormParsEpsilon);
    public void visit(FormParsSingle FormParsSingle);
    public void visit(RetTypeVoid RetTypeVoid);
    public void visit(RetTypeType RetTypeType);
    public void visit(RetTypeName RetTypeName);
    public void visit(MethodDecl MethodDecl);
    public void visit(ConstValChar ConstValChar);
    public void visit(ConstValBoolean ConstValBoolean);
    public void visit(ConstValNumber ConstValNumber);
    public void visit(ConstDecl ConstDecl);
    public void visit(ConstDeclListCommaError ConstDeclListCommaError);
    public void visit(ConstDeclListCommaNoError ConstDeclListCommaNoError);
    public void visit(ConstDeclListSingle ConstDeclListSingle);
    public void visit(ConstDeclListRec ConstDeclListRec);
    public void visit(ConstLine ConstLine);
    public void visit(Type Type);
    public void visit(NoArray NoArray);
    public void visit(Array2D Array2D);
    public void visit(Array Array);
    public void visit(VarDecl VarDecl);
    public void visit(VarDeclCommaError VarDeclCommaError);
    public void visit(VarDeclCommaNoError VarDeclCommaNoError);
    public void visit(VarDeclSingle VarDeclSingle);
    public void visit(VarDeclRec VarDeclRec);
    public void visit(VarType VarType);
    public void visit(VarDeclLine VarDeclLine);
    public void visit(DecLineError DecLineError);
    public void visit(DecLineConst DecLineConst);
    public void visit(DecLineVar DecLineVar);
    public void visit(DeclListEpsilon DeclListEpsilon);
    public void visit(DeclListRec DeclListRec);
    public void visit(ProgName ProgName);
    public void visit(Program Program);

}
