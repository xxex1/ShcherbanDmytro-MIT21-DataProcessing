abstract class Shape {
    public abstract double calculateArea();
}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }
}

class Notification {
    public void send() {
        System.out.println("Відправка повідомлення...");
    }
}

class EmailNotification extends Notification {
    @Override
    public void send() {
        System.out.println("Надіслано email-повідомлення.");
    }
}

class SMSNotification extends Notification {
    @Override
    public void send() {
        System.out.println("Надіслано SMS-повідомлення.");
    }
}

public class Main {
    public static void main(String[] args) {

        Shape triangle = new Triangle(10, 5);
        Shape square = new Square(4);

        System.out.println("Площа трикутника: " + triangle.calculateArea());
        System.out.println("Площа квадрата: " + square.calculateArea());

        System.out.println();

        Notification email = new EmailNotification();
        Notification sms = new SMSNotification();

        email.send();
        sms.send();
    }
}
