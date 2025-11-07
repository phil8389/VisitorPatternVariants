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

        CodeGeneratorVisitor cg = new CodeGeneratorVisitor();
        cu.accept(cg);
        System.out.println(cg.getCode());
        System.out.println("------------------------------------");

        System.out.println("Visitor pattern AST Example - An attempt for Breadth First Traversal");
        System.out.println("------------------------------------");
        cg.clear();
        cu.acceptForBF(cg);
        System.out.println(cg.getCode());
    }
}