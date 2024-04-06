package oop.sec02;

public class ValueData {
    int value;

    public ValueData() {
    }

    void add() {
        ++this.value;
        System.out.println("숫자 증가 value >> " + this.value);
    }
}
