// generated with ast extension for cup
// version 0.8
// 27/5/2023 11:17:38


package rs.ac.bg.etf.pp1.ast;

public class DecLineConst extends DecLine {

    private ConstLine ConstLine;

    public DecLineConst (ConstLine ConstLine) {
        this.ConstLine=ConstLine;
        if(ConstLine!=null) ConstLine.setParent(this);
    }

    public ConstLine getConstLine() {
        return ConstLine;
    }

    public void setConstLine(ConstLine ConstLine) {
        this.ConstLine=ConstLine;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstLine!=null) ConstLine.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstLine!=null) ConstLine.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstLine!=null) ConstLine.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DecLineConst(\n");

        if(ConstLine!=null)
            buffer.append(ConstLine.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DecLineConst]");
        return buffer.toString();
    }
}
