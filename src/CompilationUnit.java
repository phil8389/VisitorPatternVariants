import java.util.*;

public class CompilationUnit extends AbstractElement implements IElement {
        private Set classes;
        public CompilationUnit(String cuName) {
            name  =  cuName;
            classes = new HashSet();
        }

        public void addClass(Class clazz)
        {
            classes.add(clazz);
        }
        public void removeClass(Class clazz)
        {
            classes.remove(clazz);
        }

        public Iterator getClasses() {
            return classes.iterator();
        }


    @Override
    public void accept(Visitor visitor) {
        visitor.open(this);
        //if this is not the final node and further children, then traverse and call their accept
        Iterator iterator = classes.iterator();
        while(iterator.hasNext())
        {
            Class clazz = (Class) iterator.next();
            clazz.accept(visitor);
        }
        visitor.close(this);
    }

    public void acceptForSelective(VisitorSelective visitor) {
        if(!visitor.visit(this))
            return;
        //if this is not the final node and further children, then traverse and call their accept
        Iterator iterator = classes.iterator();
        while(iterator.hasNext())
        {
            Class clazz = (Class) iterator.next();
            clazz.acceptForSelective(visitor);
        }
    }

    @Override
    public void acceptForBF(VisitorBF visitor) {
            visitor.visit(this);
            // child nodes traversal of all elements in the object structure moved entirely to the root element unlike in the Depth First.
            Iterator iterator = classes.iterator();
            while(iterator.hasNext())
            {
            Class clazz = (Class) iterator.next();
            clazz.acceptForBF(visitor);
            }
            iterator = classes.iterator();
            while(iterator.hasNext())
            {
                Class clazz = (Class) iterator.next();
                Iterator iterator2 = clazz.getMethods();
                while(iterator2.hasNext())
                {
                    Method method = (Method) iterator2.next();
                    method.acceptForBF(visitor);
                }
                Iterator iterator3 = clazz.getFields();
                while(iterator3.hasNext())
                {
                    Field field = (Field) iterator3.next();
                    field.acceptForBF(visitor);
                }
            }

            iterator = classes.iterator();
            while(iterator.hasNext())
            {
                Class clazz = (Class) iterator.next();
                Iterator iterator4 = clazz.getMethods();
                while(iterator4.hasNext())
                {
                    Method method = (Method) iterator4.next();
                    Iterator iterator5 = method.getStatements().iterator();
                    while(iterator5.hasNext())
                    {
                        Statement statement = (Statement) iterator5.next();
                        statement.acceptForBF(visitor);
                    }
                }
            }

    }


}
