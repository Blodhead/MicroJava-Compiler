// generated with ast extension for cup
// version 0.8
// 27/5/2023 11:17:38


package rs.ac.bg.etf.pp1.ast;

public class FactorDesignator extends Factor {

    private Designator Designator;
    private FactorDesignatorOpt FactorDesignatorOpt;

    public FactorDesignator (Designator Designator, FactorDesignatorOpt FactorDesignatorOpt) {
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.FactorDesignatorOpt=FactorDesignatorOpt;
        if(FactorDesignatorOpt!=null) FactorDesignatorOpt.setParent(this);
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public FactorDesignatorOpt getFactorDesignatorOpt() {
        return FactorDesignatorOpt;
    }

    public void setFactorDesignatorOpt(FactorDesignatorOpt FactorDesignatorOpt) {
        this.FactorDesignatorOpt=FactorDesignatorOpt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Designator!=null) Designator.accept(visitor);
        if(FactorDesignatorOpt!=null) FactorDesignatorOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(FactorDesignatorOpt!=null) FactorDesignatorOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(FactorDesignatorOpt!=null) FactorDesignatorOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorDesignator(\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FactorDesignatorOpt!=null)
            buffer.append(FactorDesignatorOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorDesignator]");
        return buffer.toString();
    }
}
