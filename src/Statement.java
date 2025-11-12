import javax.lang.model.element.Name;

public class Statement extends AbstractElement implements IElement {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void acceptForBF(VisitorBF visitor) {
        visitor.visit(this);
    }

    public void acceptForSelective(VisitorSelective visitor) {
       visitor.visit(this);
    }

    public Statement(String sCode) {
        code = sCode;
    }


}
