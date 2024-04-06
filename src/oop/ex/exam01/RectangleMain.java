package oop.ex.exam01;

public class RectangleMain {
    public RectangleMain() {
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.width = 10;
        rectangle.height = 10;
        rectangle.calculateArea();
        System.out.println("넓이 >> " + rectangle.calculateArea());
        rectangle.perimeterArea();
        System.out.println("둘레 길이 >> " + rectangle.perimeterArea());
        rectangle.isSquared();
        System.out.println("정사각형 확인 여부 >> " + rectangle.isSquared());
    }
}
