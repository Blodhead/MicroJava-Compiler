// generated with ast extension for cup
// version 0.8
// 27/5/2023 11:17:38


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementOpt1 extends DesignatorStatement {

    private DesignatorStatementOpt DesignatorStatementOpt;

    public DesignatorStatementOpt1 (DesignatorStatementOpt DesignatorStatementOpt) {
        this.DesignatorStatementOpt=DesignatorStatementOpt;
        if(DesignatorStatementOpt!=null) DesignatorStatementOpt.setParent(this);
    }

    public DesignatorStatementOpt getDesignatorStatementOpt() {
        return DesignatorStatementOpt;
    }

    public void setDesignatorStatementOpt(DesignatorStatementOpt DesignatorStatementOpt) {
        this.DesignatorStatementOpt=DesignatorStatementOpt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorStatementOpt!=null) DesignatorStatementOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStatementOpt!=null) DesignatorStatementOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStatementOpt!=null) DesignatorStatementOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatementOpt1(\n");

        if(DesignatorStatementOpt!=null)
            buffer.append(DesignatorStatementOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementOpt1]");
        return buffer.toString();
    }
}
