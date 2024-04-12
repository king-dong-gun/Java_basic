package static1.sec03;

public class Data03 {
    public String name;
    public static int count;    // static은 메소드 영역에서 관리된다.

    public Data03(String name) {
        this.name = name;
        count ++;
    }
}
