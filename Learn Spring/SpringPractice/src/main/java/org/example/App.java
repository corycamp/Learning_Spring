package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //This line is creating all the objects from the xml file in the IOC container
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        /*
            getBean returns an Object type, so that is why we cast with:
            Worker worker = (Worker) context.getBean("worker");

            If we want the object immediately we can specify the class as well.
            Worker worker = context.getBean("worker",Worker.class);

            Without the name, it will search the beans by type:
            Worker worker = context.getBean(Worker.class);

            If you do it with interface and there are multiple beans that use the interface
            i.e Laptop bean and Desktop bean implement Computer.
            If you search by Computer.class, both of the beans will be returned.
            Having primary on the bean will resolve this

            //XML FILE
            <bean id="computer1" class="org.example.Laptop" primary="true"/>

            Worker worker = context.getBean(Computer.class);

         */
        Worker worker = context.getBean("worker", Worker.class);
        worker.getComputer().compile();
    }
}
