// generated with ast extension for cup
// version 0.8
// 27/5/2023 11:17:38


package rs.ac.bg.etf.pp1.ast;

public class VarDeclRec extends VarDeclList {

    private VarDeclComma VarDeclComma;
    private VarDecl VarDecl;

    public VarDeclRec (VarDeclComma VarDeclComma, VarDecl VarDecl) {
        this.VarDeclComma=VarDeclComma;
        if(VarDeclComma!=null) VarDeclComma.setParent(this);
        this.VarDecl=VarDecl;
        if(VarDecl!=null) VarDecl.setParent(this);
    }

    public VarDeclComma getVarDeclComma() {
        return VarDeclComma;
    }

    public void setVarDeclComma(VarDeclComma VarDeclComma) {
        this.VarDeclComma=VarDeclComma;
    }

    public VarDecl getVarDecl() {
        return VarDecl;
    }

    public void setVarDecl(VarDecl VarDecl) {
        this.VarDecl=VarDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclComma!=null) VarDeclComma.accept(visitor);
        if(VarDecl!=null) VarDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclComma!=null) VarDeclComma.traverseTopDown(visitor);
        if(VarDecl!=null) VarDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclComma!=null) VarDeclComma.traverseBottomUp(visitor);
        if(VarDecl!=null) VarDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclRec(\n");

        if(VarDeclComma!=null)
            buffer.append(VarDeclComma.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDecl!=null)
            buffer.append(VarDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclRec]");
        return buffer.toString();
    }
}
