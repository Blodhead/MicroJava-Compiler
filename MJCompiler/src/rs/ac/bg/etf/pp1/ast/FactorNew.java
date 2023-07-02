// generated with ast extension for cup
// version 0.8
// 27/5/2023 11:17:38


package rs.ac.bg.etf.pp1.ast;

public class FactorNew extends Factor {

    private FactorNewType FactorNewType;
    private FactorPars FactorPars;
    private FactorMatrix FactorMatrix;

    public FactorNew (FactorNewType FactorNewType, FactorPars FactorPars, FactorMatrix FactorMatrix) {
        this.FactorNewType=FactorNewType;
        if(FactorNewType!=null) FactorNewType.setParent(this);
        this.FactorPars=FactorPars;
        if(FactorPars!=null) FactorPars.setParent(this);
        this.FactorMatrix=FactorMatrix;
        if(FactorMatrix!=null) FactorMatrix.setParent(this);
    }

    public FactorNewType getFactorNewType() {
        return FactorNewType;
    }

    public void setFactorNewType(FactorNewType FactorNewType) {
        this.FactorNewType=FactorNewType;
    }

    public FactorPars getFactorPars() {
        return FactorPars;
    }

    public void setFactorPars(FactorPars FactorPars) {
        this.FactorPars=FactorPars;
    }

    public FactorMatrix getFactorMatrix() {
        return FactorMatrix;
    }

    public void setFactorMatrix(FactorMatrix FactorMatrix) {
        this.FactorMatrix=FactorMatrix;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FactorNewType!=null) FactorNewType.accept(visitor);
        if(FactorPars!=null) FactorPars.accept(visitor);
        if(FactorMatrix!=null) FactorMatrix.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FactorNewType!=null) FactorNewType.traverseTopDown(visitor);
        if(FactorPars!=null) FactorPars.traverseTopDown(visitor);
        if(FactorMatrix!=null) FactorMatrix.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FactorNewType!=null) FactorNewType.traverseBottomUp(visitor);
        if(FactorPars!=null) FactorPars.traverseBottomUp(visitor);
        if(FactorMatrix!=null) FactorMatrix.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorNew(\n");

        if(FactorNewType!=null)
            buffer.append(FactorNewType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FactorPars!=null)
            buffer.append(FactorPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FactorMatrix!=null)
            buffer.append(FactorMatrix.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorNew]");
        return buffer.toString();
    }
}
