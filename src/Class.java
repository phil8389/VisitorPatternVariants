import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Class extends AbstractElement implements IElement {

    private Set Methods;
    private Set Fields;
    private Set Constructors;
    public Class(String cName) {
        this.name = cName;
        Methods = new HashSet();
        Fields = new HashSet();
        Constructors = new HashSet();
    }
    public void addMethod(Method method)
    {
        Methods.add(method);
    }
    public void removeMethod(Method method)
    {
        Methods.remove(method);
    }

    public Iterator getMethods()
    {
        return Methods.iterator();
    }

    public void addField(Field field)
    {
        Fields.add(field);
    }
    public void removeField(Field field)
    {
        Fields.remove(field);
    }
    public Iterator getFields()
    {
        return Fields.iterator();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.open(this);
        //if this is not the final node and further children, then traverse and call their accept
        Iterator iterator = Methods.iterator();
        while(iterator.hasNext())
        {
            Method method = (Method) iterator.next();
            method.accept(visitor);
        }
        Iterator iterator2 = Fields.iterator();
        while(iterator2.hasNext())
        {
            Field field = (Field) iterator2.next();
            field.accept(visitor);
        }

        visitor.close(this);
    }

    public void acceptForSelective(VisitorSelective visitor) {
        if(!visitor.visit(this))
            return;
        //if this is not the final node and further children, then traverse and call their accept
        Iterator iterator = Methods.iterator();
        while(iterator.hasNext())
        {
            Method method = (Method) iterator.next();
            method.acceptForSelective(visitor);
        }
        Iterator iterator2 = Fields.iterator();
        while(iterator2.hasNext())
        {
            Field field = (Field) iterator2.next();
            field.acceptForSelective(visitor);
        }
    }

    @Override
    public void acceptForBF(VisitorBF visitor) {
        visitor.visit(this);
    }
}
