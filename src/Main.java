import java.util.List;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Visitor pattern - AST example discussed in the 6461 class!");
        System.out.println("\n ------------------------------------");

        Field f1 = new Field("private int age;");
        Field f2 = new Field("protected String loginName;");
        Method m1 = new Method("registerCustomer");
        m1.addStatement(new Statement("this.year = year"));
        m1.addStatement(new Statement("this.loginName = name"));
        Method m2 = new Method("getCustomers");
        m2.addStatement(new Statement("return s1.getCustomers()"));
        Class class1 = new Class("Customer");
        class1.addMethod(m1);
        class1.addMethod(m2);
        class1.addField(f1);
        class1.addField(f2);

        Class class2 = new Class("Order");
        Method m3 = new Method("getOrders");
        m3.addStatement(new Statement("return s1.getOrders()"));
        Method m4 = new Method("placeOrder");
        m4.addStatement(new Statement("return s1.placeOrders()"));
        class2.addMethod(m3);
        class2.addMethod(m4);
        class2.addField(new Field("private int quantity;"));
        class2.addField(new Field("private double price;"));
        CompilationUnit cu = new CompilationUnit("CU-1");
        cu.addClass(class1);
        cu.addClass(class2);

        //Importance of having iterator pattern
        //cu.getClasses().removeAll(cu.getClasses());

        CodeGeneratorVisitor cg = new CodeGeneratorVisitor();
        cu.accept(cg);
        System.out.println(cg.getCode());
        System.out.println("------------------------------------");

        System.out.println("Visitor pattern AST Example - An attempt for Breadth First Traversal");
        System.out.println("------------------------------------");
        CodeGeneratorVisitorBF cgBF = new CodeGeneratorVisitorBF();
        cu.acceptForBF(cgBF);
        System.out.println(cgBF.getCode());

        System.out.println("------------------------------------");

        System.out.println("Visitor pattern AST Example - An attempt to not to visit certain elements determined by the visitor");
        System.out.println("------------------------------------");

        Field f10 = new Field("private int age;");
        Field f20 = new Field("protected String tempLoginName;");
        Method m10 = new Method("registerCustomer");
        m10.addStatement(new Statement("this.year = year"));
        m10.addStatement(new Statement("this.loginName = name"));
        Method m20 = new Method("testGetCustomers");
        m20.addStatement(new Statement("return s1.getCustomers()"));
        Class class10 = new Class("Customer");
        class10.addMethod(m10);
        class10.addMethod(m20);
        class10.addField(f10);
        class10.addField(f20);

        Class class20 = new Class("TestOrder");
        Method m30 = new Method("getOrders");
        m3.addStatement(new Statement("return s1.getOrders()"));
        Method m40 = new Method("placeOrder");
        m40.addStatement(new Statement("return s1.placeOrders()"));
        class20.addMethod(m30);
        class20.addMethod(m40);
        class20.addField(new Field("private int quantity;"));
        class20.addField(new Field("private double price;"));
        CompilationUnit cu2 = new CompilationUnit("CU-1");
        cu2.addClass(class10);
        cu2.addClass(class20);

        CodeGeneratorVisitorSelective cgSelective = new CodeGeneratorVisitorSelective();
        cu2.acceptForSelective(cgSelective);
        System.out.println(cgSelective.getCode());

    }
}