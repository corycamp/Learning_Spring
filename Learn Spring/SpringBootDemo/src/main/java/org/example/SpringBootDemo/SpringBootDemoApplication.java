package org.example.SpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
        /*
            SpringApplication.run(SpringBootDemoApplication.class, args);
            Returns an ApplicationContext

            The ApplicationContext allows you to access parts of Spring like the IOC container
            i.e. remember Spring can create and hold object for you in a container in the JVM
            it can also link different object together with dependency injection

            Any object created by Spring is called a "Bean" so you get the objects with the getBean method
         */
		ApplicationContext context = SpringApplication.run(SpringBootDemoApplication.class, args);
        Worker worker1 = context.getBean(Worker.class);
        Worker worker2 = context.getBean(Worker.class);
        worker2.code();

	}

}
