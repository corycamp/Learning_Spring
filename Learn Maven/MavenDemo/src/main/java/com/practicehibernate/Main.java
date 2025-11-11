package com.practicehibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.Arrays;
import java.util.List;


/*
    CRUD - CREATE READ UPDATE DELETE

    CREATE - Can save data with persist - persist(Object o)
    READ - Can read data with find - find(Class c, Object id)
    UPDATE - Can update data with merge/saveOrUpdate - merge(Object o)
    DELETE - Can delete data with remove - remove(Object o)
 */


public class Main {

    public static void main(String[] args){
        try{
            handleL2Cache();
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
    }

    /*
        JCache dependency in Maven
        @Cacheable annotation on desired class
     */
    public static void handleL2Cache(){
        try{
            SessionFactory sf = new Configuration()
                    .addAnnotatedClass(Laptop.class)
                    .configure()
                    .buildSessionFactory();

            Session session = sf.openSession();
            Laptop l1 = session.find(Laptop.class,2);
            System.out.println(l1);

            session.close();

            Session session1 = sf.openSession();

            Laptop l2 = session1.find(Laptop.class,2);
            System.out.println(l2);

            session1.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void handlefindNLoad(){
        try{
            SessionFactory sf = new Configuration()
                    .addAnnotatedClass(Laptop.class)
                    .configure()
                    .buildSessionFactory();
            Session session = sf.openSession();

            //This does lazy loading of the object requests
            //It will not call the query and get the data until the variable is used.
            //So no query is called until I did System.out.println(laptop);

            //Eager loading is done when using find(Laptop.class,1)
            //It calls the query on that same line of code
            Laptop laptop = session.getReference(Laptop.class,1);
            System.out.println(laptop);

        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
    }

    public static void handleHQL(){

        try{
            SessionFactory sf = new Configuration()
                    .addAnnotatedClass(Laptop.class)
                    .configure()
                    .buildSessionFactory();

            Session session = sf.openSession();

            //Select * from laptop where ram = 32 -> SQL
            //from Laptop where ram = 32 -> HQL

//            Query<Laptop> query = session.createQuery("from Laptop where ram=32", Laptop.class);
//            List<Laptop> laptops = query.getResultList();

            //With filter queries
            String brand1 = "Asus";
            String brand2 = "Apple";
            Query query = session.createQuery("select brand, model from Laptop where brand in (?1,?2)");
            query.setParameter(1,brand1);
            query.setParameter(2,brand2);
            List<Object[]> laptops = query.getResultList();

            for(Object[] obj : laptops){
                System.out.printf("%s\t%s\n",(String) obj[0], (String) obj[1]);
            }
            System.out.println(laptops);

            session.close();
            sf.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //When the relationships aren't specified in the Class
    public static void handleEmbeddable(){
        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("Asus");
        l1.setModel("ROG");
        l1.setRam(32);

        Laptop l2 = new Laptop();
        l2.setLid(2);
        l2.setBrand("Dell");
        l2.setModel("XPS");
        l2.setRam(32);

        Laptop l3 = new Laptop();
        l3.setLid(3);
        l3.setBrand("Apple");
        l3.setModel("Macbook");
        l3.setRam(32);

        Worker worker1 = new Worker();
        worker1.setId(1);
        worker1.setName("Test1");
        worker1.setTech("Java");

        Worker worker2 = new Worker();
        worker2.setId(2);
        worker2.setName("Test2");
        worker2.setTech("C++");

        Worker worker3 = new Worker();
        worker3.setId(3);
        worker3.setName("Test3");
        worker3.setTech("Python");

        worker1.setLaptops(Arrays.asList(l1,l2));
        worker2.setLaptops(Arrays.asList(l3));


        try{
            SessionFactory sf = new Configuration()
                    .addAnnotatedClass(Worker.class)
                    .addAnnotatedClass(Laptop.class)
                    .configure()
                    .buildSessionFactory();
            Session session = sf.openSession();

            session.persist(l1);
            session.persist(l2);
            session.persist(l3);

            session.persist(worker1);
            session.persist(worker2);
//            session.persist(worker3);


            Transaction transaction = session.beginTransaction();
            transaction.commit();
            session.close();
            sf.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(l1.toString());
    }

    public static void removeTable(){
        String sql = "DROP Table employee";

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "Cory", "Benten2014@");
            PreparedStatement s = con.prepareStatement(sql);
            boolean complete = s.execute();
            if(complete) System.out.println("Did it");
            s.close();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void handleChangingColumnName(Employee emp){
        try {
            SessionFactory sf = new Configuration()
                    .addAnnotatedClass(Employee.class)
                    .configure()
                    .buildSessionFactory();
            Session session = sf.openSession();
            Transaction transaction = session.beginTransaction();

            session.persist(emp);
            transaction.commit();
            session.close();
            sf.close();
        }catch(Exception e){
            System.out.println("Error creating session " + e.getMessage());
        }
    }

    public static void handleDeleteData(SessionFactory sf){
        try {
            Session session = sf.openSession();
            //Find a student in student table with id 1
            Student sToDelete = session.find(Student.class,1);
            Transaction transaction = session.beginTransaction();
            /*
                Behind the scenes merge uses Select * to check if the data exist
                If it does exist it updates, however if the data doesn't exist
                merge will do an insert to add the data
             */
            session.remove(sToDelete);
            transaction.commit();
            session.close();
            sf.close();
        }catch(Exception e){
            System.out.println("Error creating session " + e.getMessage());
        }
    }

    public static void handleUpdatingData(SessionFactory sf, Student updatedStudent){
        try {
            Session session = sf.openSession();
            Transaction transaction = session.beginTransaction();
            /*
                Behind the scenes merge uses Select * to check if the data exist
                If it does exist it updates, however if the data doesn't exist
                merge will do an insert to add the data
             */
            session.merge(updatedStudent);
            transaction.commit();
            session.close();
            sf.close();
        }catch(Exception e){
            System.out.println("Error creating session " + e.getMessage());
        }
    }

    public static void handleGettingData(SessionFactory sf, int id){
        Student s2 = null;
        try {
            Session session = sf.openSession();
            s2 = session.find(Student.class, id);
            session.close();
            sf.close();
        }catch(Exception e){
            System.out.println("Error creating session " + e.getMessage());
        }
        System.out.println(s2);
    }

    public static void handleSendingData(Student s1, SessionFactory sf){
        try {
            Session session = sf.openSession();
            session.persist(s1);

            Transaction transaction = session.beginTransaction();
            transaction.commit();
            session.close();
            sf.close();
        }catch(Exception e){
            System.out.println("Error creating session " + e.getMessage());
        }
    }
}
