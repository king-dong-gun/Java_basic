package oop.ex.exam01;

public class Rectangle {
    int width;
    int height;

    public Rectangle() {
    }

    int calculateArea() {
        return this.width * this.height;
    }

    int perimeterArea() {
        return 2 * (this.width + this.height);
    }

    boolean isSquared() {
        return this.width == this.height;
    }
}
