package org.example.SpringBootDemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*
    @Component annotation tells Spring that they can create an object for this class to store in the IOC container
 */

@Component
public class Worker {

    /*
        This tells Spring that it is their responsibility to get this object from the container
     */
    @Autowired
    Laptop laptop;
    public void code(){
        laptop.compile();
    }
}
