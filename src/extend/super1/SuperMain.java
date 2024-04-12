package extend.super1;

public class SuperMain {
    public static void main(String[] args) {
        Child child = new Child();
        child.call();
        child.hello();

        Parent parent = new Parent();
        parent.hello();

    }
}
