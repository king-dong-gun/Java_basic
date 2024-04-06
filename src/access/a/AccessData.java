package access.a;


public class AccessData {
    public int publicField;
    int defualtField;
    private int privateField;

    public AccessData() {
    }

    public void publicMethod() {
        System.out.println("publicMethod 호출 >> " + this.publicField);
    }

    void defualtMethod() {
        System.out.println("defualtMethod 호출  >> " + this.defualtField);
    }

    private void privateMethod() {
        System.out.println("privateMethod 호출 >> " + this.privateField);
    }

    public void innerAccess() {
        System.out.println("내부 호출");
        this.publicField = 100;
        this.defualtField = 200;
        this.publicField = 300;
        this.publicMethod();
        this.defualtMethod();
        this.privateMethod();
    }
}