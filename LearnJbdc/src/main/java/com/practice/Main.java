package com.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String [] args){
        Student s1 = new Student();
        s1.setName("Test2");
        s1.setsAge(24);
        s1.setRollNo(102);

        /*
         To create a Session, you need a Session Factory
         Session factory is heavy weight so only use one, but you can have multiple sessions
         */

        /*

        Before

         Configuration cfg = new Configuration();
         cfg.addAnnotatedClass(com.practice.Student.class);
         //uses xml file to setup config, can place this in the resource folder at root of main folder
         cfg.configure();
         */

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.practice.Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();
        session.persist(s1);

        Transaction transaction = session.beginTransaction();
        transaction.commit();
        session.close();
        sf.close();
        System.out.println(s1);
    }
}
