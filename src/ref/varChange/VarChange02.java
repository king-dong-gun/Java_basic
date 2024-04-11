package ref.varChange;

import ref.method.Data;

public class VarChange02 {
    public VarChange02() {
    }

    public static void main(String[] args) {
        Data dataA = new Data();
        dataA.value = 10;
        System.out.println("dataA 참조값 >> " + String.valueOf(dataA));
        System.out.println("dataB 참조값 >> " + String.valueOf(dataA));
        System.out.println("dataA >> " + dataA.value);
        System.out.println("dataB >> " + dataA.value);
        System.out.println("-------------------------");
        dataA.value = 20;
        System.out.println("dataA 참조값 >> " + String.valueOf(dataA));
        System.out.println("dataB 참조값 >> " + String.valueOf(dataA));
        System.out.println("dataA >> " + dataA.value);
        System.out.println("dataB >> " + dataA.value);
        System.out.println("-------------------------");
        dataA.value = 30;
        System.out.println("dataA 참조값 >> " + String.valueOf(dataA));
        System.out.println("dataB 참조값 >> " + String.valueOf(dataA));
        System.out.println("dataA >> " + dataA.value);
        System.out.println("dataB >> " + dataA.value);
    }
}
