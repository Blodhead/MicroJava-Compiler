// generated with ast extension for cup
// version 0.8
// 27/5/2023 11:17:38


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclListRec extends ConstDeclList {

    private ConstDeclListComma ConstDeclListComma;
    private ConstDecl ConstDecl;

    public ConstDeclListRec (ConstDeclListComma ConstDeclListComma, ConstDecl ConstDecl) {
        this.ConstDeclListComma=ConstDeclListComma;
        if(ConstDeclListComma!=null) ConstDeclListComma.setParent(this);
        this.ConstDecl=ConstDecl;
        if(ConstDecl!=null) ConstDecl.setParent(this);
    }

    public ConstDeclListComma getConstDeclListComma() {
        return ConstDeclListComma;
    }

    public void setConstDeclListComma(ConstDeclListComma ConstDeclListComma) {
        this.ConstDeclListComma=ConstDeclListComma;
    }

    public ConstDecl getConstDecl() {
        return ConstDecl;
    }

    public void setConstDecl(ConstDecl ConstDecl) {
        this.ConstDecl=ConstDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclListComma!=null) ConstDeclListComma.accept(visitor);
        if(ConstDecl!=null) ConstDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclListComma!=null) ConstDeclListComma.traverseTopDown(visitor);
        if(ConstDecl!=null) ConstDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclListComma!=null) ConstDeclListComma.traverseBottomUp(visitor);
        if(ConstDecl!=null) ConstDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclListRec(\n");

        if(ConstDeclListComma!=null)
            buffer.append(ConstDeclListComma.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDecl!=null)
            buffer.append(ConstDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclListRec]");
        return buffer.toString();
    }
}
