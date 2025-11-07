public interface IElement {
    public void accept(Visitor visitor);
    public void acceptForBF(Visitor visitor);
}

