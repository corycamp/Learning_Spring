package org.example;


import java.beans.ConstructorProperties;

public class Worker {
    private int age;
    private Computer computer;

//    @ConstructorProperties({"age","laptop"})
//    public Worker(int age, Laptop laptop) {
//        this.age = age;
//        this.laptop = laptop;
//    }

    public Worker(){}

    public Worker(int age){
        this.age = age;
    }

    public void code(){
        System.out.println("Test");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "age=" + age +
                ", computer=" + computer +
                '}';
    }
}
