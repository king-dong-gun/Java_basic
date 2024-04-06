package ref.nullPoint;

import ref.init.InitData;

public class NullMain {
    public NullMain() {
    }

    public static void main(String[] args) {
        InitData data = null;
        System.out.println("data= " + String.valueOf(data));
        data = new InitData();
        System.out.println("data= " + String.valueOf(data));
        data = null;
        System.out.println("data= " + String.valueOf(data));
    }
}
