public interface IElement {
    public void accept(Visitor visitor);
    public void acceptForBF(VisitorBF visitorBF);
}

