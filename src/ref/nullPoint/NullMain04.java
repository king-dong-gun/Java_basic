package ref.nullPoint;

import ref.method.BigData;
import ref.method.Data;

public class NullMain04 {
    public NullMain04() {
    }

    public static void main(String[] args) {
        BigData bigData = new BigData();
        bigData.data = new Data();
        System.out.println("BigData.count = " + bigData.count);
        System.out.println("BigData.data = " + String.valueOf(bigData.data));
        System.out.println("BigData.data.value = " + bigData.data.value);
    }
}
