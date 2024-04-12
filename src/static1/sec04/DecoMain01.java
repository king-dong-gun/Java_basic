package static1.sec04;

public class DecoMain01 {
    public static void main(String[] args) {
        String str = "hello java";
        DecoUtil01 util01 = new DecoUtil01();
        String deco = util01.deco(str);

        System.out.println("before >> " + str);
        System.out.println("after >> " + deco);
    }
}
