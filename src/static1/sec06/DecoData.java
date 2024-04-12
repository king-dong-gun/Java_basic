package static1.sec06;

public class DecoData {
    private int instanceValue;
    private static int staticValue;

    public static void staticCall() {
//        instanceValue++;    // 인스턴스 변수 접근, complie error
//        instanceMethod();    // 인스턴스 메소드 접근, complie error

        staticValue++;  // 정적 변수 접근
        staticMethod(); // 정적 메소드 접근
    }
    public static void staticCall(DecoData decoData) {
        decoData.intanceCall();
        decoData.instanceMethod();
    }

    public void intanceCall() {
        instanceValue++;    // 인스턴스 변수 접근
        instanceMethod();   // 인스턴스 메소드 접근

        staticValue++;      // static 변수 접근
        staticMethod();     // static 메소드 접근
    }

    private void instanceMethod() {
        System.out.println("instanceValue >> " + instanceValue);
    }
    private static void staticMethod() {
        System.out.println("staticValue >> " + staticValue);
    }

}
