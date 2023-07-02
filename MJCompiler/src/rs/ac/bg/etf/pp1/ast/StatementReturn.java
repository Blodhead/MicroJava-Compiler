// generated with ast extension for cup
// version 0.8
// 27/5/2023 11:17:38


package rs.ac.bg.etf.pp1.ast;

public class StatementReturn extends Statement {

    private StatementReturnOpt StatementReturnOpt;

    public StatementReturn (StatementReturnOpt StatementReturnOpt) {
        this.StatementReturnOpt=StatementReturnOpt;
        if(StatementReturnOpt!=null) StatementReturnOpt.setParent(this);
    }

    public StatementReturnOpt getStatementReturnOpt() {
        return StatementReturnOpt;
    }

    public void setStatementReturnOpt(StatementReturnOpt StatementReturnOpt) {
        this.StatementReturnOpt=StatementReturnOpt;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(StatementReturnOpt!=null) StatementReturnOpt.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StatementReturnOpt!=null) StatementReturnOpt.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StatementReturnOpt!=null) StatementReturnOpt.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementReturn(\n");

        if(StatementReturnOpt!=null)
            buffer.append(StatementReturnOpt.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementReturn]");
        return buffer.toString();
    }
}
