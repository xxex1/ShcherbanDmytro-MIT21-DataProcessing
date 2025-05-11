class Vehicle {
    protected String make;
    protected String model;

    public Vehicle(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public void displayInfo() {
        System.out.println("Марка: " + make);
        System.out.println("Модель: " + model);
    }
}

class Motorcycle extends Vehicle {
    private int engineCapacity;

    public Motorcycle(String make, String model, int engineCapacity) {
        super(make, model);
        this.engineCapacity = engineCapacity;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Обʼєм двигуна: " + engineCapacity + " куб.см");
    }
}

class Employee {
    protected String name;
    protected String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void displayInfo() {
        System.out.println("Імʼя: " + name);
        System.out.println("Посада: " + position);
    }
}

class Manager extends Employee {
    private int teamSize;

    public Manager(String name, String position, int teamSize) {
        super(name, position);
        this.teamSize = teamSize;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Розмір команди: " + teamSize);
    }
}

public class Main {
    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle("Toyota", "Corolla");
        vehicle.displayInfo();

        System.out.println();

        Motorcycle moto = new Motorcycle("Yamaha", "MT-07", 689);
        moto.displayInfo();

        System.out.println();

        // Employee / Manager
        Employee emp = new Employee("Олександр", "Інженер");
        emp.displayInfo();

        System.out.println();

        Manager manager = new Manager("Ірина", "Керівник відділу", 8);
        manager.displayInfo();
    }
}
