import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Method extends AbstractElement implements IElement {
   private Set statements = new HashSet<Statement>();
   private Set fields = new HashSet<Field>();
  public Method(String mName)
  {
      name=mName;
      fields = new HashSet();
  }
    public void addStatement(Statement statement)
    {
        statements.add(statement);
    }

    public  void removeStatement(Statement statement)
    {
        statements.remove(statement);
    }
    public Set getStatements()
    {
        return statements;
    }

    @Override
    public void accept(Visitor visitor) {
        //if this is not the final node and further children, then traverse and call their accept
        visitor.open(this);
      final Iterator iterator  = statements.iterator();
       while(iterator.hasNext())
       {
         Statement s =  (Statement) iterator.next();
         s.accept(visitor);
       }
       visitor.close(this);
    }

    @Override
    public void acceptForBF(VisitorBF visitor) {
    visitor.visit(this);
    }

    public void acceptForSelective(VisitorSelective visitor) {
        if (!visitor.visit(this))
            return;
        final Iterator iterator = statements.iterator();
            while (iterator.hasNext()) {
                Statement s = (Statement) iterator.next();
                    s.acceptForSelective(visitor);
            }


    }
}
