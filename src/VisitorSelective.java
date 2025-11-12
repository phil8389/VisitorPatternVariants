public interface VisitorSelective {
  public boolean visit(Field field);
  public boolean visit(Statement statement);
  public boolean visit(Method method);
  public boolean visit(Class clazz);
  public boolean visit(CompilationUnit cu);
}
