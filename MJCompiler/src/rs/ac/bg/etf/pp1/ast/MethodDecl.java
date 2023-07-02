// generated with ast extension for cup
// version 0.8
// 27/5/2023 11:17:38


package rs.ac.bg.etf.pp1.ast;

public class MethodDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private RetTypeName RetTypeName;
    private FormPars FormPars;
    private MethodVarDeclList MethodVarDeclList;
    private StatementLine StatementLine;

    public MethodDecl (RetTypeName RetTypeName, FormPars FormPars, MethodVarDeclList MethodVarDeclList, StatementLine StatementLine) {
        this.RetTypeName=RetTypeName;
        if(RetTypeName!=null) RetTypeName.setParent(this);
        this.FormPars=FormPars;
        if(FormPars!=null) FormPars.setParent(this);
        this.MethodVarDeclList=MethodVarDeclList;
        if(MethodVarDeclList!=null) MethodVarDeclList.setParent(this);
        this.StatementLine=StatementLine;
        if(StatementLine!=null) StatementLine.setParent(this);
    }

    public RetTypeName getRetTypeName() {
        return RetTypeName;
    }

    public void setRetTypeName(RetTypeName RetTypeName) {
        this.RetTypeName=RetTypeName;
    }

    public FormPars getFormPars() {
        return FormPars;
    }

    public void setFormPars(FormPars FormPars) {
        this.FormPars=FormPars;
    }

    public MethodVarDeclList getMethodVarDeclList() {
        return MethodVarDeclList;
    }

    public void setMethodVarDeclList(MethodVarDeclList MethodVarDeclList) {
        this.MethodVarDeclList=MethodVarDeclList;
    }

    public StatementLine getStatementLine() {
        return StatementLine;
    }

    public void setStatementLine(StatementLine StatementLine) {
        this.StatementLine=StatementLine;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(RetTypeName!=null) RetTypeName.accept(visitor);
        if(FormPars!=null) FormPars.accept(visitor);
        if(MethodVarDeclList!=null) MethodVarDeclList.accept(visitor);
        if(StatementLine!=null) StatementLine.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(RetTypeName!=null) RetTypeName.traverseTopDown(visitor);
        if(FormPars!=null) FormPars.traverseTopDown(visitor);
        if(MethodVarDeclList!=null) MethodVarDeclList.traverseTopDown(visitor);
        if(StatementLine!=null) StatementLine.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(RetTypeName!=null) RetTypeName.traverseBottomUp(visitor);
        if(FormPars!=null) FormPars.traverseBottomUp(visitor);
        if(MethodVarDeclList!=null) MethodVarDeclList.traverseBottomUp(visitor);
        if(StatementLine!=null) StatementLine.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDecl(\n");

        if(RetTypeName!=null)
            buffer.append(RetTypeName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormPars!=null)
            buffer.append(FormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodVarDeclList!=null)
            buffer.append(MethodVarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementLine!=null)
            buffer.append(StatementLine.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDecl]");
        return buffer.toString();
    }
}
