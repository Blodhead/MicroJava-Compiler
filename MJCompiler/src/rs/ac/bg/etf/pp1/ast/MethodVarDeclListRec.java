// generated with ast extension for cup
// version 0.8
// 27/5/2023 11:17:38


package rs.ac.bg.etf.pp1.ast;

public class MethodVarDeclListRec extends MethodVarDeclList {

    private MethodVarDeclList MethodVarDeclList;
    private MethodVarDeclLine MethodVarDeclLine;

    public MethodVarDeclListRec (MethodVarDeclList MethodVarDeclList, MethodVarDeclLine MethodVarDeclLine) {
        this.MethodVarDeclList=MethodVarDeclList;
        if(MethodVarDeclList!=null) MethodVarDeclList.setParent(this);
        this.MethodVarDeclLine=MethodVarDeclLine;
        if(MethodVarDeclLine!=null) MethodVarDeclLine.setParent(this);
    }

    public MethodVarDeclList getMethodVarDeclList() {
        return MethodVarDeclList;
    }

    public void setMethodVarDeclList(MethodVarDeclList MethodVarDeclList) {
        this.MethodVarDeclList=MethodVarDeclList;
    }

    public MethodVarDeclLine getMethodVarDeclLine() {
        return MethodVarDeclLine;
    }

    public void setMethodVarDeclLine(MethodVarDeclLine MethodVarDeclLine) {
        this.MethodVarDeclLine=MethodVarDeclLine;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodVarDeclList!=null) MethodVarDeclList.accept(visitor);
        if(MethodVarDeclLine!=null) MethodVarDeclLine.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodVarDeclList!=null) MethodVarDeclList.traverseTopDown(visitor);
        if(MethodVarDeclLine!=null) MethodVarDeclLine.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodVarDeclList!=null) MethodVarDeclList.traverseBottomUp(visitor);
        if(MethodVarDeclLine!=null) MethodVarDeclLine.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodVarDeclListRec(\n");

        if(MethodVarDeclList!=null)
            buffer.append(MethodVarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodVarDeclLine!=null)
            buffer.append(MethodVarDeclLine.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodVarDeclListRec]");
        return buffer.toString();
    }
}
