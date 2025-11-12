public class CodeGeneratorVisitorBF implements VisitorBF {
    private StringBuilder codeGeneartated;
    public CodeGeneratorVisitorBF() {
        codeGeneartated = new StringBuilder();
    }
    @Override
    public void visit(Method method)
    {
        codeGeneartated.append("\n Method ").append(method.getName()).append(" visited.");
    }
    @Override
    public void visit(Class clazz) {
      codeGeneartated.append("\n Class ").append(clazz.getName()).append(" visited.");
    }
    @Override
    public void visit(CompilationUnit cu) {
        codeGeneartated.append("\n Compilation Unit ").append(cu.getName()).append(" visited.");
    }

    @Override
    public void visit(Statement statetement) {
        codeGeneartated.append("\n").append(statetement.getCode());
    }
    @Override
    public void visit(Field f) {
        codeGeneartated.append("\n").append(f.getCode());
    }

    public String getCode() {
        return codeGeneartated.toString();
    }

    public void clear() {
        codeGeneartated = new StringBuilder();
    }
}
