package oop.sec02;

public class ValueDataMain {
    public ValueDataMain() {
    }

    public static void main(String[] args) {
        ValueData vData = new ValueData();
        add(vData);
        add(vData);
        add(vData);
        System.out.println("최종숫자 >> " + vData.value);
    }

    static void add(ValueData vData) {
        ++vData.value;
        System.out.println("숫자 증가 vData >> " + vData.value);
    }
}
