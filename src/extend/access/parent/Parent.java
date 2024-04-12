package extend.access.parent;

public class Parent {

    public int publicValue;
    protected int protectedValue;
    int defaultValue;
    private int privateValue;

    public void publicMethod() {
        System.out.println("Parent.publicMethod");
    }

    protected void protectedMethod() {
        System.out.println("Parent.protectedMethod");
    }

    void defaultMethod() {
        System.out.println("Parent.defaultMethod");
    }
    public void printParent() {
        System.out.println("==Parent 메소드 안==");
        System.out.println("publicValue = " + publicValue);
        System.out.println("protectedValue = " + protectedValue);
        System.out.println("defaultValue = " + defaultValue);       // 부모 메소드 안에서 접근가능
        System.out.println("privateValue = " + privateValue);       // 부모 메소드 안에서 접근가능

        // 부모 메소드 안에서 모두 접근 가능
        defaultMethod();
        protectedMethod();


    }
}

