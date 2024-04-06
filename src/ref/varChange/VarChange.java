package ref.varChange;

public class VarChange {
    public VarChange() {
    }

    public static void main(String[] args) {
        int a = 10;
        int b = a;
        System.out.println("a >> " + a);
        System.out.println("b >> " + a);
        a = 20;
        System.out.println("a 변경 >> " + a);
        System.out.println("a >> " + a);
        System.out.println("b >> " + b);
        b = 30;
        System.out.println("b 변경 >> " + b);
        System.out.println("a >> " + a);
        System.out.println("b >> " + b);
        System.out.println("a >> " + a);
        System.out.println("b >> " + a);
    }
}
