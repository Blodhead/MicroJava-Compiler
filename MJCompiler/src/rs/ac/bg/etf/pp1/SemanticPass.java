package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticPass extends VisitorAdaptor {

	private Struct currentType = null;
	private Obj currentMethod = null;
	private boolean errorDetected = false;
	private boolean mullOp = false;
	private boolean addOp = false;
	private boolean isArray = false;
	private boolean isMatrix = false;
	private boolean boolNew = false;
	private Struct arrayType = null;
	private Struct matrixHelper = null;
	private Struct arrayHelper = null;
	private boolean assignErr = false;
	private int loopcnt = 0;
	private int whilecnt = 0;
	private int continuecnt = 0;
	public int nVars = 0;
	private boolean cond = false;

	Logger log = Logger.getLogger(getClass());

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0 : info.getLine();
		if (line != 0)
			msg.append(" na liniji ").append(line);
		log.info(msg.toString());
	}

	public void visit(ProgName progName) {
		progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
		MyTab.myInit();
		Tab.openScope();
		Obj temp1 = Tab.insert(1,"temp1", new Struct(1));
		Obj temp2 = Tab.insert(1,"temp2", new Struct(1));
	}

	public void visit(Program program) {
		Tab.chainLocalSymbols(program.getProgName().obj);
		Tab.closeScope();
		nVars = Tab.currentScope.getnVars();
	}

	public void visit(RetTypeVoid retTypeVoid) {
		if (retTypeVoid != null)
			currentType = Tab.noType;
		retTypeVoid.struct = Tab.noType;
		// System.out.println("VOID HERE");
	}

	public void visit(RetTypeType retTypeType) {
		retTypeType.struct = currentType;
		// System.out.println("VOID HERE");
	}

	public void visit(RetTypeName retTypeName) {

		Obj obj = Tab.find(retTypeName.getMethodName());

		if (obj == Tab.noObj) {
			currentMethod = Tab.insert(Obj.Meth, retTypeName.getMethodName(), currentType);
			retTypeName.obj = currentMethod;
			// currentMethod.setLevel(2);
			Tab.openScope();
			// if(myTab.noType == currentType)
			// System.out.println("true void");
		} else {
			report_error("Double function declaration", retTypeName);
		}

	}

	public void visit(MethodDecl methodDecl) {
		Tab.chainLocalSymbols(currentMethod);
		if (methodDecl.getRetTypeName().getRetType().struct != Tab.noType)
			if (methodDecl.getRetTypeName().getRetType().struct != methodDecl.getStatementLine().struct) {
				if (methodDecl.getStatementLine().struct == null)
					report_error("Missing return statement", methodDecl);
				else
					report_error("Wring return type", methodDecl);
			} //else
				//Tab.closeScope();
	}

	public void visit(Type type) {

		Obj obj = Tab.find(type.getTypeName());

		if (obj == Tab.noObj) {
			report_error("Variable must have a valid type", type);
		} else {
			if (obj.getKind() == Obj.Type) {
				// System.out.println("Jesam type");
				currentType = obj.getType();
			} else {
				report_error("Not Type Kind", type);
			}
		}

	}

	public void visit(DecLineVar dec) {
		currentType = null;
	}

	public void visit(DecLineConst dec) {
		currentType = null;
	}

	public void visit(FactorMatrixSingle fms) {

		isMatrix = true;
	}

	public void visit(VarDecl varDecl) {
		Obj obj = Tab.find(varDecl.getVarName());

		if (obj == Tab.noObj) {

			if (isMatrix == true) {

				Struct depth1 = new Struct(Struct.Array, currentType);
				Struct depth2 = new Struct(Struct.Array, depth1);
				varDecl.obj = Tab.insert(Obj.Var, varDecl.getVarName(), depth2);
				isMatrix = false;

			} else if (isArray == true) {

				Struct depth1 = new Struct(Struct.Array, currentType);
				Tab.insert(Obj.Var, varDecl.getVarName(), depth1);
				isArray = false;

			} else {
				Tab.insert(Obj.Var, varDecl.getVarName(), currentType);
			}

		} else {
			report_error("Double constant definition", varDecl);
		}
	}

	public void visit(Array array) {
		isArray = true;
	}

	public void visit(Array2D array2D) {
		isMatrix = true;
	}

	public void visit(ConstDecl constDecl) {

		Obj obj = Tab.find(constDecl.getConstName());

		if (obj == Tab.noObj) {
			if (currentType == constDecl.getConstVal().struct)
				Tab.insert(Obj.Con, constDecl.getConstName(), currentType);
			else
				report_error("Wrong Type", constDecl);
		} else {
			report_error("Double variable declaration", constDecl);
		}

	}

	public void visit(Designator designator) {// da moze i za matricu
		designator.obj = Tab.find(designator.getDesignatorName());
		if (designator.obj == Tab.noObj && isArray == false) { // && isMatrix == false
			report_error("undefined variable", designator);
		}
	}

	public void visit(DesignatorListDesignator designatorListDesignator) {// niz=niz2 se odvija u Designator-u

		// Obj temp;
		// isArray= true;

		if (designatorListDesignator.getExpr().struct == null || designatorListDesignator.getExpr().struct.getKind() != Struct.Int) {
			report_error("undefined variable", designatorListDesignator);
		}

		if (designatorListDesignator.getDesignatorList() instanceof DesignatorListEpsilon) {

			if (designatorListDesignator.getParent() instanceof DesignatorListDesignator) {// matrix[]([])
				designatorListDesignator.struct = Tab
						.find(((Designator) designatorListDesignator.getParent().getParent()).getDesignatorName())
						.getType().getElemType();
			} else if (designatorListDesignator.getParent() instanceof Designator) {// matrix([]) || array([])
				designatorListDesignator.struct = Tab
						.find(((Designator) designatorListDesignator.getParent()).getDesignatorName()).getType()
						.getElemType();
			}

		} else if (designatorListDesignator.getDesignatorList() instanceof DesignatorListDesignator
				&& designatorListDesignator.getParent() instanceof Designator) {// matrix([])[]
			designatorListDesignator.struct = designatorListDesignator.getDesignatorList().struct.getElemType();

		}

		try {
			((Designator) designatorListDesignator.getParent().getParent()).obj = Tab
					.find(((Designator) designatorListDesignator.getParent().getParent()).getDesignatorName());
		} catch (Exception e) {
			((Designator) designatorListDesignator.getParent()).obj = Tab
					.find(((Designator) designatorListDesignator.getParent()).getDesignatorName());
		}

	}

	public void visit(DesignatorListEpsilon designatorListEpsilon) {
		if (designatorListEpsilon.getParent() instanceof Designator) {
			designatorListEpsilon.struct = Tab
					.find(((Designator) designatorListEpsilon.getParent()).getDesignatorName()).getType();
		}
	}

	public void visit(Term term) {
		term.struct = term.getFactor().struct;// OK
		if (mullOp == true) {
			Struct arg1 = term.getFactor().struct;
			Struct arg2 = term.getTermList().struct;
			if (term.getTermList() instanceof TermListRec)
				if (!arg1.compatibleWith(arg2)) {
					report_error("These values are not compatible", term);
				}
			/*
			 * if (arg1.getKind() == Struct.Array) arg1 =
			 * term.getFactor().struct.getElemType();
			 * 
			 * if (arg2.getKind() == Struct.Array) arg2 =
			 * term.getTermList().struct.getElemType(); // in needed int check durin
			 * multiplication, put it here if (arg1 != null && arg2 != null) if
			 * (!arg1.compatibleWith(arg2) && mullOp == true) {
			 * report_error("These values are not compatible", term); }
			 */
			mullOp = false;
		}

	}

	public void visit(Expr expr) {

		expr.struct = expr.getTerm().struct;

		if (addOp == true) {
			// ovdeee

			Struct arg1 = expr.getTerm().struct;
			Struct arg2 = expr.getExprList().struct;
			addOp = false;
			if (expr.getExprList() instanceof ExprListSingle)
				if (!arg1.compatibleWith(arg2)) {
					report_error("These values are not compatible", expr);
				}

		}

	}

	/*
	 * if (arg1.getKind() == Struct.Array) arg1 =
	 * expr.getTerm().struct.getElemType();
	 * 
	 * if (arg2.getKind() == Struct.Array) arg2 =
	 * expr.getExprList().struct.getElemType();
	 * 
	 * if (arg1 != null && arg2 != null) if (!arg1.compatibleWith(arg2)) {
	 * report_error("These values are not compatible", expr); }
	 */

	public void visit(ExprListSingle exprListSingle) {// sabiranje-oduzimanje

		Struct s1 = exprListSingle.getExprList().struct;
		Struct s2 = exprListSingle.getTerm().struct;

		if (s1 != null && s2 != null)
			if (!s1.assignableTo(s2)) {
				report_error("Prazan Term", exprListSingle);
				return;
			}

		exprListSingle.struct = exprListSingle.getTerm().struct;// OK

		if (exprListSingle.getParent() instanceof ExprListSingle)
			((ExprListSingle) exprListSingle.getParent()).struct = exprListSingle.getTerm().struct;
		else if (exprListSingle.getParent() instanceof ExprListEpsilon)
			((ExprListEpsilon) exprListSingle.getParent()).struct = exprListSingle.getTerm().struct;

		if (exprListSingle.struct != null)// za negativne brojeve
			addOp = true;
		else {
			report_error("Prazan Term", exprListSingle);
		}
	}

	public void visit(ExprListEpsilon exprListEpsilon) {
		if (exprListEpsilon.getParent() instanceof Expr)// u tom slucaju se sabira
			exprListEpsilon.struct = new Struct(Struct.Int);// OK

	}

	public void visit(TermListRec termListRec) {
		termListRec.struct = termListRec.getFactor().struct;// OK
		if (termListRec.struct != null)// za negativne brojeve
			mullOp = true;
		else {
			report_error("Prazan Factor", termListRec);
		}
	}

	public void visit(FactorDesignator factorDesignator) {
		factorDesignator.getDesignator().obj = Tab.find(factorDesignator.getDesignator().getDesignatorName());
		try {
			factorDesignator.struct = factorDesignator.getDesignator().getDesignatorList().struct;
		} catch (Exception e) {
			factorDesignator.struct = factorDesignator.getDesignator().obj.getType();
		}
	}

	public void visit(FactorLiterals factorLiterals) {
		factorLiterals.struct = factorLiterals.getLiterals().struct;
	}

	public void visit(FactorNew factorNew) {
		factorNew.struct = factorNew.getFactorNewType().struct; // OK
		boolNew = true;
		// report_info("NEW " + factorNew.struct.getKind(),factorNew);
	}

	public void visit(FactorNewType factorNewType) {
		factorNewType.struct = currentType;
		currentType = null;
		// report_info("Type is " + factorNewType.struct.getKind(),factorNewType);
	}

	public void visit(FactorRec factorRec) {
		factorRec.struct = factorRec.getExpr().struct; // OK
	}

	public void visit(LiteralsNum literalsNum) {
		currentType = literalsNum.struct = Tab.intType; // OK
	}

	public void visit(LiteralsChar literalsChar) {
		currentType = literalsChar.struct = Tab.charType; // OK
	}

	public void visit(LiteralsBoolean literalsBoolean) {
		currentType = literalsBoolean.struct = MyTab.boolType; // OK
	}

	public void visit(ConstValNumber constValNumber) {
		currentType = constValNumber.struct = Tab.intType; // OK
	}

	public void visit(ConstValBoolean constValBoolean) {
		currentType = constValBoolean.struct = MyTab.boolType; // OK
	}

	public void visit(ConstValChar constValChar) {
		currentType = constValChar.struct = Tab.charType;
	}

	public void visit(DesignatorStatementOptAssign designatorStatemen) {

		Struct rightSide = designatorStatemen.getExpr().struct;
		Struct leftSide = designatorStatemen.getDesignator().getDesignatorList().struct;
		if (boolNew == true) {// only if new operator
			boolNew = false;
			Obj left = designatorStatemen.getDesignator().obj;

			if (left.getType().getKind() == Struct.Array)// if array or matrix
				if (left.getType().getElemType().getKind() == Struct.Array
						&& designatorStatemen.getDesignator().getDesignatorList() instanceof DesignatorListEpsilon) {
					leftSide = Tab.find(designatorStatemen.getDesignator().getDesignatorName()).getType().getElemType()
							.getElemType();// matrix
				} else
					leftSide = Tab.find(designatorStatemen.getDesignator().getDesignatorName()).getType().getElemType();// arr
			else if (left.getType().getKind() == Obj.Var) // if any var
				leftSide = designatorStatemen.getDesignator().obj.getType();
			else {
				report_error("Designator must be a variable or array", designatorStatemen);
			}

			if (rightSide != null)
				if (rightSide.getElemType() != null)
					if (rightSide.getKind() == Struct.Array) {
						rightSide = rightSide.getElemType();
					}
		}
		if (leftSide != null && rightSide != null) {// da li moze da se dodeli

			if (leftSide.assignableTo(rightSide) == false) {
				report_error("Values are unassignable", designatorStatemen);
				return;
			}
		} else {
			report_error("Values are null", designatorStatemen);
			return;
		}
	}

	public void visit(DesignatorStatementOpt2 designatorStatementOpt2) {

		Struct stm1 = designatorStatementOpt2.getDesignatorOpt().struct;
		Struct stm2 = designatorStatementOpt2.getDesignatorStatementList().struct;
		Struct stm3 = designatorStatementOpt2.getDesignator().obj.getType();

		String message = "";

		if (stm3 != null) {
			if (stm3.getElemType() != null) {
				if (stm3.getKind() == Struct.Array) {
					stm3 = stm3.getElemType();
				}
			}
		}

		if (stm1 != null) {
			if (stm1.getElemType() != null) {
				if (stm1.getKind() == Struct.Array) {
					stm1 = stm1.getElemType();
					if (!stm1.assignableTo(stm3)) {
						message = "smt1 not assignableTo stm3!";
					}
				}
			}
		}

		if (stm2 != null) {
			if (stm2.getElemType() != null) {
				if (stm2.getKind() == Struct.Array) {
					stm2 = stm2.getElemType();
					if (!stm2.assignableTo(stm3)) {
						message = "smt2 not assignableTo stm3!";
					}
				}
			}
		}

		if (assignErr == false)
			if (message != "") {
				report_error(message, designatorStatementOpt2);
			} else {
				// report_info(designatorStatementOpt2.getDesignator().getDesignatorName()+"
				// assigned values to array of arguments ", designatorStatementOpt2);
			}
		arrayType = null;
		assignErr = false;

	}

	public void visit(DesignatorOptSingle designatorOptSingle) {

		if (assignErr == true) {
			return;
		}
		Struct comp = Tab.find(designatorOptSingle.getDesignator().getDesignatorName()).getType();

		if (arrayType != null) {
			if (arrayType.getElemType() != null) {
				if (arrayType.getKind() == Struct.Array) {
					arrayType = arrayType.getElemType();
				}
			}
		}

		if (comp != null) {
			if (comp.getElemType() != null) {
				if (comp.getKind() == Struct.Array) {
					comp = comp.getElemType();
				}
			}
		}

		if (arrayType == null) {
			designatorOptSingle.struct = comp;
			arrayType = comp;
		} else if (!comp.assignableTo(arrayType)) {
			report_error("All assignation array params must be same type", designatorOptSingle);
			assignErr = true;
		}
	}

	public void visit(DesignatorStatementListRec designatorStatementListRec) {
		designatorStatementListRec.struct = designatorStatementListRec.getDesignatorOpt().struct;

	}

	public void visit(StatementReturn statementReturn) {
		statementReturn.struct = statementReturn.getStatementReturnOpt().struct;

	}

	public void visit(StatementReturnOptSingle statementReturnOptSingle) {
		statementReturnOptSingle.struct = statementReturnOptSingle.getExpr().struct;

	}

	public void visit(StatementLineRec statementLineRec) {
		statementLineRec.struct = statementLineRec.getStatement().struct;

	}

	public void visit(DesignatorStatementOptIncrement designatorStatementOptIncrement) {// da moze i matrica

		Struct check = designatorStatementOptIncrement.getDesignator().getDesignatorList().struct;

		if (check.getKind() == Struct.Array) {
			report_error("Designator must be a primitive variable or an array", designatorStatementOptIncrement);
			return;
		}

	}

	public void visit(DesignatorStatementOptDecrement designatorStatementOptDecrement) {// da moze i matrica

		Struct check = designatorStatementOptDecrement.getDesignator().getDesignatorList().struct;

		if (check.getKind() == Struct.Array) {
			report_error("Designator must be a primitive variable or an array", designatorStatementOptDecrement);
			return;
		}

	}

	public void visit(CondFactOptSingle condFactOptSingle) {

		whilecnt++;
		loopcnt++;
		continuecnt++;

	}

	public void visit(StatementWhile statementWhile) {

		if (whilecnt > 0) {
			whilecnt--;
			if (loopcnt > whilecnt)
				loopcnt--;
			if (continuecnt > whilecnt)
				continuecnt--;
		}

	}

	public void visit(StatementContinue statementContinue) {

		if (continuecnt > 0 && continuecnt >= whilecnt) {
			continuecnt--;
			loopcnt--;
		} else {
			report_error("Must be in while loop to use continue", statementContinue);
		}

	}

	public void visit(StatementBreak statementBreak) {

		if (loopcnt > 0 && loopcnt >= whilecnt) {
			loopcnt--;
			continuecnt--;
		} else {
			report_error("Must be in while loop to use break", statementBreak);
		}

	}

	public void visit(StatementPrint statementPrint) {// da moze i za matricu

		if (statementPrint.getExpr().struct != Tab.intType && statementPrint.getExpr().struct != Tab.charType) {
			report_error("Print statement must be int or char", statementPrint);
		}
	}

	public void visit(StatementRead statementRead) {// da moze i za matricu

		if (statementRead.getDesignator().getDesignatorList().struct != Tab.intType && statementRead.getDesignator().getDesignatorList().struct != Tab.charType) {
			report_error("Read statement must be int or char", statementRead);
		}
	}
	
	public boolean passed() {
		return !errorDetected;
	}

}
