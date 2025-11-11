/*
 * Notes
 * 
 * When using abstract class, you can't create an Object of that class.
 * You have to extend it with another class, and any method marked as abstract
 * has to be overriden in the subclass
 * 
 * Abstract classes can have both normal and abstract methods. Normal classes can't have abstract methods
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

abstract class Car { // Abstract class

    private String name;

    abstract public void drive();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

class BMW extends Car { // Concrete class

    public BMW() {
        super.setName("BMW");
    }

    public void drive() {
        System.out.println("Driving....");
    }

    class Wheels {
        private int size;

        public Wheels() {
            this.size = 19;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }
}

/*
 * Notes
 * 
 * By default every method in interface is public abstract
 * 
 * Also it's not a class so you can't instantiate it.
 * 
 * Interface will show you the design, it will show you the methods needed
 * but you have to define them, hence why it is abstract
 * 
 * 
 * Use impement key word to use it
 * Also any variable made in an interface are final and static
 * 
 * You can implement multiple interfaces
 * 
 * class B implements A,C ......
 * 
 * An interface can extend another interface
 * 
 * interface D...
 * 
 * interface C extends D...
 * 
 */

interface TestInterface{
    int age = 24;           //final and static
    String name = "Cory";   //final and static
    void show();
}


/*
 * 
 * Notes
 * 
 * Enum Objects are Named constants
 * 
 * You assign the value like any other data type
 * e.g
 * Status s = Status.Failed;
 * 
 * This will give you a value of Failed.
 * 
 */

 enum Status{
    Running, Failed, Pending, Success;      //Named constants
 }

/*
 * 
 * Notes
 * 
 * enum extends the Enum class, so it works like a class
 * 
 * Each value specified in the enum are objects, even the named constants
 * So if you create a constructor in the enum, it can be applied to the objects
 * 
 * So price is being added 
 * 
 */

 enum Laptops{
    Windows(2000), Macbook(3000), Dell(3000), Surface(2000), XPS;

    private int price;

    private Laptops(){
        this.price = 500;
    }

    private Laptops(int price){
        this.price = price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public int getPrice(){
        return this.price;
    }
}

/*
 * 
 * Annotations are used to specify your intention, for example,
 * if you want to override a method you would place @Override
 * above the method, this will tell the compiler that you want to override
 * the method in the super class
 * 
 * Now if you accidentally missed typed the name of the class you are overriding,
 * A error message will show that there is no method in the parent class with that,
 * allowing you to make the fix before compiling 
 * 
 * 
 * So if you had
 * 
 * class A .....
 * public void show(){}
 * 
 * And 
 * 
 * class B extends A .....
 * @Override
 * public void show2(){}
 * 
 * You would get an error saying there are no methods in class A with that name
 * 
 */

 class A{
    public void show(){}
 }

 class B extends A{

    @Override
    public void show(){}
 }


/*
 * 
 * Lambda Expressions can only be used in functional interfaces
 * Since there is only one method and Java can infer which one you want to implement
 * 
 * So rather then doing an anonymous inner class like
 * 
 * testFunctional obj = new testFunctional(){ public void show(){ System.out.println("hello");}}
 * 
 * You can do 
 * 
 * testFunctional obj = () -> System.out.println("hello");
 * 
 * And still calling it by obj.show();
 * 
 * 
 * When doing it with return type methods, you get rid of the return key word
 * look at the function "withoutReturn" below for example
 * 
 */

@FunctionalInterface
interface testFunctional {
    void show();    
}

@FunctionalInterface
interface Calc {
    int add(int i, int j);    
}



public class Main {

    public static void main(String[] args) {
        
    }

    public static void takingInput() throws IOException{
        System.out.println("Enter a number");
        BufferedReader bf = null;
        Scanner sc = null;
        try{
            bf = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(bf.readLine());

            sc = new Scanner(System.in);
            System.out.println("Enter second number");
            int num2 = sc.nextInt();

            System.out.println(num);
            System.out.println(num2);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        finally
        {
            bf.close();
            sc.close();
        }


        //New Java allows you to do try with resources
        try(BufferedReader bf2 = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println(Integer.parseInt(bf2.readLine()));
        }
    }

    public static void handleArithmetic(){

        int i = 0;
        int j = 0;

        try
        {
            j = 18;
            //throw keyword to throw specific exception
            if(i==0)
                throw new ArithmeticException("Can't divide by zero");
            int ans = j/i;
            System.out.println("Ans is: " + ans);
        }
        catch(ArithmeticException e)
        {
            System.out.println("This is the message from error: " + e);
        }
    }


    public static void withoutReturn(){
        Calc c = (i,j) -> i+j;
        int result = c.add(10,15);
        System.out.printf("Result %d\n",result);
    }

    public static void lambdaTest(){

        testFunctional obj = () -> System.out.println("printing show");

        obj.show();
    }

    public static void laptopPrices(){
        Laptops[] laps = Laptops.values();
        
        for(Laptops lap: laps){
            System.out.printf("Device: %s\tPrice: %d\n",lap, lap.getPrice());
        }
    }

    public static void statusWithElse(){
        Status s = Status.Pending;

        //When using Switch with Enum, you can provide the named constant
        switch (s) {
            case Running:
                System.out.println("All good");
                break;
            case Failed:
                System.out.println("OOps");
                break;
            case Pending:
                System.out.println("Waiting");
                break;
            case Success:
                System.out.println("Yaaay");
                break;
            default:
                break;
        }
    }

    public static void checkingStatus(){
        Status s = Status.Running;
        System.out.println(s);

        //Will get you the position of the specific status like an array        
        System.out.println(s.ordinal());

        //Give an array of all the Status values
        Status[] ss = Status.values();

        for(Status status : ss){
            System.out.printf("Status %s : %d\n", status, status.ordinal());
        }
    }

    public static void callCar(){

         /*
         * This is a Anonymous Inner class
         * This allows you to specify a Inner class and without compiling the class
         * specified above
         */

        BMW car = new BMW() {
            public void drive() {
                System.out.println("New updated drive....");
            }
        };

        /*
         * This is a regular Inner class, where Wheels is the inner class of BMW
         * There is two was to initialize Wheels, 1 is to call the instance of the BMW
         * object, which is car
         * followed by the new key word and instantiating the object
         * e.g BMW.Wheels wheels = car.new Wheels();
         * 
         * Another way is to have the Wheels class be static
         * So if you had
         * Static class Wheels....
         * 
         * You could have done:
         * 
         * BMW.Wheels wheels = new BMW.Wheels();
         */

        BMW.Wheels wheels = car.new Wheels();
        System.out.println(car.getName());
        car.drive();
        System.out.println(wheels.getSize());

        /*
         * So you can't create an object from an Abstract class, we know that
         * However, you can create an Anonymous Inner class for the abstract class when
         * instantiating the object
         * 
         * This is the sane as doing
         * 
         * class Test extends Car.....
         * 
         * instead of creating a class just to use the drive method, we can create an
         * Anonymous Inner class and handle it like this
         * 
         * Car car2 = new Car() {
         * public void drive() {
         * System.out.println("Driving abstract car...");
         * }
         * };
         * 
         * 
         * REMEMBER WE ARE NOT CREATING A CLASS OF CAR WHICH IS ABSTRACT, we are
         * creating a class of the Anonymous class.
         */

        Car car2 = new Car() {
            public void drive() {
                System.out.println("Driving abstract car...");
            }
        };
        car2.drive();
    }
}
