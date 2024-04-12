package static1.sec01;

public class DataCountMain01 {
    public static void main(String[] args) {
        Data01 data01 = new Data01("A");
        System.out.println("A count >> " + data01.count);

        Data01 data02 = new Data01("A");
        System.out.println("A count >> " + data02.count);

        Data01 data03 = new Data01("A");
        System.out.println("A count >> " + data03.count);
    }
}
