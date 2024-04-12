package final1;

public class FinalLocalMain {
    public static void main(String[] args) {
        // final 지역변수
        final int data1;
        data1 = 10;     // final은 최초 한번만 할당 가능
        // data1 = 20;     // 컴파일 오류

        // final 지역변수2
        final int data2;
        data2 = 10;
        // data2 = 20;     // 컴파일 오류

        method(10);  // 메소드 호출할때 인수로 넘기는 값 고정
    }

    static void method(final int parameter) {
        // parameter = 20;  // 컴파일 오류
    }
}
