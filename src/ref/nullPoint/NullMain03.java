package ref.nullPoint;

import ref.method.BigData;

public class NullMain03 {
    public NullMain03() {
    }

    public static void main(String[] args) {
        BigData bigData = new BigData();
        System.out.println("BigData.count = " + bigData.count);
        System.out.println("BigData.data = " + String.valueOf(bigData.data));
        System.out.println("BigData.data.value = " + bigData.data.value);
    }
}
