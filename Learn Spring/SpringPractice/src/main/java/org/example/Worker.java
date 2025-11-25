package org.example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;

@Component
public class Worker {
    private int age;
    @Autowired
    //This is the name of the bean when using Component and AutoWire, this is just the name of the class but lower case
    @Qualifier("computer")
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
