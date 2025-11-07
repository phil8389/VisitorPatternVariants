public class CodeGeneratorVisitor implements Visitor {
    private StringBuilder codeGeneartated;
    public CodeGeneratorVisitor() {
        codeGeneartated = new StringBuilder();
    }
    @Override
    public void open(Method method)
    {
        codeGeneartated.append("\n Method ").append(method.getName()).append(" starts:");
    }
    @Override
    public void close(Method method) {
        codeGeneartated.append("\n Method ").append(method.getName()).append(" ended");
    }

    @Override
    public void open(Class clazz) {
      codeGeneartated.append("\n Class ").append(clazz.getName()).append(" starts:");
    }

    @Override
    public void close(Class clazz) {
        codeGeneartated.append("\n Class ").append(clazz.getName()).append(" ended.");
    }
    @Override
    public void open(CompilationUnit cu) {
        codeGeneartated.append("\n Compilation Unit ").append(cu.getName()).append(" starts:");
    }

   public void close(CompilationUnit cu) {
       codeGeneartated.append("\n Compilation Unit ").append(cu.getName()).append(" ended.");
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
