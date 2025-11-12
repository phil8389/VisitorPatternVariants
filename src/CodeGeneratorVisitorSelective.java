public class CodeGeneratorVisitorSelective implements VisitorSelective {
    private StringBuilder codeGeneartated;
    public CodeGeneratorVisitorSelective() {
        codeGeneartated = new StringBuilder();
    }
    @Override
    public boolean visit(Method method)
    {
        if(method.getName().contains("test")) {
            codeGeneartated.append("\n Method ").append(method.getName()).append(" ignored.");
            return false;
        }
        codeGeneartated.append("\n Method ").append(method.getName()).append(" visited.");
        return true;
    }
    @Override
    public boolean visit(Class clazz) {
        if(clazz.getName().contains("Test")) {
            codeGeneartated.append("\n Class ").append(clazz.getName()).append(" ignored.");
            return false;
        }
      codeGeneartated.append("\n Class ").append(clazz.getName()).append(" visited.");
      return true;
    }
    @Override
    public boolean visit(CompilationUnit cu) {
        codeGeneartated.append("\n Compilation Unit ").append(cu.getName()).append(" visited.");
        return true;
    }

    @Override
    public boolean visit(Statement statetement) {
        codeGeneartated.append("\n").append(statetement.getCode());
        return true;
    }
    @Override
    public boolean visit(Field f) {
        if(f.getCode().contains("temp")) {
            codeGeneartated.append("\n Field ").append(f.getCode()).append(" ignored.");
            return false;
        }
        codeGeneartated.append("\n").append(f.getCode());
        return  true;
    }

    public String getCode() {
        return codeGeneartated.toString();
    }

    public void clear() {
        codeGeneartated = new StringBuilder();
    }
}
