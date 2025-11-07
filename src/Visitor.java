import java.beans.Expression;

public interface Visitor {
  public void visit(Field field);
  public void visit(Statement statement);
  public void open(Method method);
  public void close(Method method);
  public void open(Class clazz);
  public void close(Class clazz);
  public void open(CompilationUnit cu);
  public void close(CompilationUnit cu);
}
