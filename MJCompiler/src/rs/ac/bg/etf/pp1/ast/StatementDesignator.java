// generated with ast extension for cup
// version 0.8
// 27/5/2023 11:17:38


package rs.ac.bg.etf.pp1.ast;

public class StatementDesignator extends Statement {

    private DesignatorSemi DesignatorSemi;

    public StatementDesignator (DesignatorSemi DesignatorSemi) {
        this.DesignatorSemi=DesignatorSemi;
        if(DesignatorSemi!=null) DesignatorSemi.setParent(this);
    }

    public DesignatorSemi getDesignatorSemi() {
        return DesignatorSemi;
    }

    public void setDesignatorSemi(DesignatorSemi DesignatorSemi) {
        this.DesignatorSemi=DesignatorSemi;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorSemi!=null) DesignatorSemi.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorSemi!=null) DesignatorSemi.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorSemi!=null) DesignatorSemi.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementDesignator(\n");

        if(DesignatorSemi!=null)
            buffer.append(DesignatorSemi.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementDesignator]");
        return buffer.toString();
    }
}
