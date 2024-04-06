package oop.sec02;

public class ValueObjectMain {
    public ValueObjectMain() {
    }

    public static void main(String[] args) {
        ValueData vData = new ValueData();
        vData.add();
        vData.add();
        vData.add();
        System.out.println("최종 숫자 >> " + vData.value);
    }
}
