package static1.sec05;

public class DecoMain02 {
    public static void main(String[] args) {
        String str = "hello java";
        String deco = DecoUtil02.deco(str);

        System.out.println("before >> " + str);
        System.out.println("after >> " + deco);
    }
}
