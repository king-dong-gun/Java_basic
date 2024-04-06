package access.sec03;

public class PublicClass {
    public PublicClass() {
    }

    public static void main(String[] args) {
        new PublicClass();
        new DefaultClass1();
        new DefaultClass2();
    }
}
