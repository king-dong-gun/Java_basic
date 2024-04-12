package static1.sec06;

public class DecoDataMain {
    public static void main(String[] args) {
        System.out.println("1. 정적호출");
        DecoData.staticCall();

        System.out.println("2. 인스턴스 호출1");
        DecoData decoData1 = new DecoData();
        decoData1.intanceCall();

        System.out.println("3. 인스턴스 호출2");
        DecoData decoData2 = new DecoData();
        decoData2.intanceCall();

        DecoData.staticCall(decoData1);
    }
}
