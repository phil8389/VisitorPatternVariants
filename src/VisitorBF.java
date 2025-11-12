public interface VisitorBF {
  public void visit(Field field);
  public void visit(Statement statement);
  public void visit(Method method);
  public void visit(Class clazz);
  public void visit(CompilationUnit cu);

}
