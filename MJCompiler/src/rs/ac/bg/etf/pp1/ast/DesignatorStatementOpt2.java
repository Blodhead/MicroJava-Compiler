// generated with ast extension for cup
// version 0.8
// 27/5/2023 11:17:38


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementOpt2 extends DesignatorStatement {

    private DesignatorOpt DesignatorOpt;
    private DesignatorStatementList DesignatorStatementList;
    private Designator Designator;

    public DesignatorStatementOpt2 (DesignatorOpt DesignatorOpt, DesignatorStatementList DesignatorStatementList, Designator Designator) {
        this.DesignatorOpt=DesignatorOpt;
        if(DesignatorOpt!=null) DesignatorOpt.setParent(this);
        this.DesignatorStatementList=DesignatorStatementList;
        if(DesignatorStatementList!=null) DesignatorStatementList.setParent(this);
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
    }

    public DesignatorOpt getDesignatorOpt() {
        return DesignatorOpt;
    }

    public void setDesignatorOpt(DesignatorOpt DesignatorOpt) {
        this.DesignatorOpt=DesignatorOpt;
    }

    public DesignatorStatementList getDesignatorStatementList() {
        return DesignatorStatementList;
    }

    public void setDesignatorStatementList(DesignatorStatementList DesignatorStatementList) {
        this.DesignatorStatementList=DesignatorStatementList;
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorOpt!=null) DesignatorOpt.accept(visitor);
        if(DesignatorStatementList!=null) DesignatorStatementList.accept(visitor);
        if(Designator!=null) Designator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorOpt!=null) DesignatorOpt.traverseTopDown(visitor);
        if(DesignatorStatementList!=null) DesignatorStatementList.traverseTopDown(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorOpt!=null) DesignatorOpt.traverseBottomUp(visitor);
        if(DesignatorStatementList!=null) DesignatorStatementList.traverseBottomUp(visitor);
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatementOpt2(\n");

        if(DesignatorOpt!=null)
            buffer.append(DesignatorOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorStatementList!=null)
            buffer.append(DesignatorStatementList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementOpt2]");
        return buffer.toString();
    }
}
