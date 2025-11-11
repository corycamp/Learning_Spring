
/*
 * Notes
 * 
 * With packages. it follows a folder structure where to access the files,
 * it is "folder name"."file name"
 * 
 * So to access AdvCalc file, it is tools.AdvCals
 * 
 * Also this is for files. If you have java.util.Scanner, 
 * java.* will not work, because it will get all files in the java folder (not the sub folders)
 * So you have to do java.util.* for that to work.
 * 
 */
import tools.AdvCalc;

class Student {
    String name;
    int age;

}

/*
 * 
 * Using the final keyword acts as a constant identifier
 * When used with a variable, final int num = 9;
 * that num cannot be changed.
 * 
 * If done to a class, like
 * final class Mobile....
 * That class cannot be extended.
 * 
 * 
 * If done to a method, like
 * 
 * public final show()...
 * You cannot override this method if a the class containing it is extended.
 * 
 */

// Static
class Mobile {
    String name;
    static String type;

    /*
     * This gets called once and can be used to initialize static variables
     * With a contructor, the variable would have been initilized each time a object
     * is made but now it gets called once.
     * 
     * There is a Class loader in the JVM, so classes get initilized once before
     * object is instanciated.
     *
     */
    static {
        type = "Smartphone";
    }
}

class Test extends AdvCalc {
    public Test() {
        System.out.println(this.result);
    }
}

public class Demo {

    public static void main(String args[]) throws ClassNotFoundException {

        /*
         * This will cause the system class loader to load this class, even
         * withoutinitilizing it.
         * Class.forName("Mobile");
         */

        AdvCalc c = new AdvCalc();
        new Test();
        System.out.println(c.add(10, 20));
        // System.out.println(c.result);

    }

    /*
     * Notes
     * Static means it belongs to the class and is shared. So when the type is set
     * to Static
     * Every instance of the Mobile calls will have this variable set to the same
     * value.
     * Also to access and modify static variables, you use the Class name not the
     * reference
     * so m1 and m2 are references, and Mobile is the class name.
     * 
     * 
     * Note
     * If you want to work with a non static method, you need to create an object
     * with it
     */

    public static void handleSameName() {
        Mobile m1 = new Mobile();
        Mobile m2 = new Mobile();
        m1.name = "Iphone";
        m2.name = "Samsung";

        System.out.println(m1.name);
        System.out.println(m2.name);
        System.out.println(Mobile.type);
    }

    public static void advanceLoop() {
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        s1.age = 20;
        s2.age = 21;
        s3.age = 22;

        Student arr[] = new Student[3];
        arr[0] = s1;
        arr[1] = s2;
        arr[2] = s3;

        for (Student s : arr) {
            System.out.println(s.age);
        }
    }

}
