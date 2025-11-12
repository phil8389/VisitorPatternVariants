public class Field extends AbstractElement implements IElement {
    public Field(String fCode) {
        code = fCode;

    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void acceptForSelective(VisitorSelective visitor) {
        visitor.visit(this);
    }

    @Override
    public void acceptForBF(VisitorBF visitor) {
        visitor.visit(this);
    }
}
