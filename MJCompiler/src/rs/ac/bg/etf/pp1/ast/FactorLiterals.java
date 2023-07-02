// generated with ast extension for cup
// version 0.8
// 27/5/2023 11:17:38


package rs.ac.bg.etf.pp1.ast;

public class FactorLiterals extends Factor {

    private Literals Literals;

    public FactorLiterals (Literals Literals) {
        this.Literals=Literals;
        if(Literals!=null) Literals.setParent(this);
    }

    public Literals getLiterals() {
        return Literals;
    }

    public void setLiterals(Literals Literals) {
        this.Literals=Literals;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Literals!=null) Literals.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Literals!=null) Literals.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Literals!=null) Literals.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorLiterals(\n");

        if(Literals!=null)
            buffer.append(Literals.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorLiterals]");
        return buffer.toString();
    }
}
