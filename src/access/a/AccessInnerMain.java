package access.a;

public class AccessInnerMain {
    public AccessInnerMain() {
    }

    public static void main(String[] args) {
        AccessData accessData = new AccessData();
        accessData.publicField = 1;
        accessData.publicMethod();
        accessData.defualtField = 2;
        accessData.defualtMethod();
        accessData.innerAccess();
    }
}
