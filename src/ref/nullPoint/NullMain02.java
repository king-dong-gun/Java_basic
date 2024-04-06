package ref.nullPoint;

import ref.Data;

public class NullMain02 {
    public NullMain02() {
    }

    public static void main(String[] args) {
        Data data = null;
        ((Data)data).value = 10;
        System.out.println("1. data = " + ((Data)data).value);
    }
}
