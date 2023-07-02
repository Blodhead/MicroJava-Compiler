// generated with ast extension for cup
// version 0.8
// 27/5/2023 11:17:38


package rs.ac.bg.etf.pp1.ast;

public class FactorMatrixSingle extends FactorMatrix {

    private FactorPars FactorPars;

    public FactorMatrixSingle (FactorPars FactorPars) {
        this.FactorPars=FactorPars;
        if(FactorPars!=null) FactorPars.setParent(this);
    }

    public FactorPars getFactorPars() {
        return FactorPars;
    }

    public void setFactorPars(FactorPars FactorPars) {
        this.FactorPars=FactorPars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FactorPars!=null) FactorPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FactorPars!=null) FactorPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FactorPars!=null) FactorPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorMatrixSingle(\n");

        if(FactorPars!=null)
            buffer.append(FactorPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorMatrixSingle]");
        return buffer.toString();
    }
}
