package final1.sec03;

public class FinalRefMain {
    public static void main(String[] args) {
        final Data data = new Data();

        // data = new Data();  // 이미 참조했기 때문에 할당 불가능

        // 참조 대상의 값은 변경 가능
        data.value = 10;
        System.out.println(data.value);
        data.value = 20;
        System.out.println(data.value);
    }
}
