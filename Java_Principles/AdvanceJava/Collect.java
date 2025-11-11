import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

class Student{
    private String name;
    private int age;

    public Student(){}
    public Student(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }
    
}

public class Collect {

    public static void main(String[] args) {
        handleConstructorReference();

    }

    public static void handleConstructorReference(){
        List<String> names = Arrays.asList("Cory", "Bre");
        List<Student> students = new ArrayList<>();

        //First way of looping through names and creating student
        // for(String name : names){
        //     students.add(new Student(name));
        // }

        //Second way of using a stream, creating a student for each with map
        //And then returning a list
        // students = names.stream()
        //             .map(name->new Student(name))
        //             .toList();

        //Create a stream of the names list
        //use map to return a student object for each name
        //A constructor reference is used to create new Student
        //Stream is retured as a List
        students = names.stream()
                    .map(Student::new)
                    .toList();

        System.out.println(students);
    }

    public static void handleMethodReference(){
        /*
         * Notes
         * 
         * You can specify the class you are getting the method from
         * and use "Class"::"method name" and it will allow you to use it
         */
        List<String> names = Arrays.asList("Cory", "Bre");

        List<String> uNames = names.stream()
                                    //This is a method reference
                                    .map(String::toUpperCase)
                                    .toList();
        uNames.forEach(System.out::println);     
        
    }

    public static void handleOptional(){
        List<String> pets = Arrays.asList("Dog","Bunny","Cat","Bird");
        /*
         * 
         * Notes
         * 
         * To avoid Null Pointer Exception you can use Optional
         * class on the data type. To handle cases where the data
         * is not found, you can use "orElse()" function to handle
         * 
         */

        Optional<String> pet = pets.stream()
                        .filter(s->s.contains("B"))
                        .findFirst();

        /* Or
         * 
         * String pet = pets.stream()
         *                  .filter(s->s.contains("B"))
         *                  .findFirst()
         *                  .orElse("Not Found");
         * 
         * When done like this, you can't surround the data type
         * with Optional<>
         */
        
        
        System.out.println(pet.orElse("Not Found"));
    }

    public static void handleStream(){
        List<Integer> nums = Arrays.asList(2,4,6,8);

        //For each takes in a functional interface argument called
        //Consumer
        // nums.forEach(n -> System.out.println(n));

        /*
         * 
         * Notes
         * Stream can only be used once
         * So once you call a method on the stream it will give
         * and error if you call another
         * 
         * E.g
         * 
         * Stream<Integer> s1 = nums.stream();
         * 
         * System.out.println(s1.count());
         * System.out.println(s1.count());
         * 
         * This will error out since stream has already been used
         * 
         */

        
        // This is the long way of doing it
        // Stream<Integer> s1 = nums.stream();
        // Stream<Integer> s2 = s1.filter(n -> n%2==0);
        // Stream<Integer> s3 = s2.map(n -> n*2);
        // int result = s3.reduce(0, (c,e) -> c+e);
        

        //More optimal way for stream
        //Each operation already returns a stream that can be used once
        //So by having the operation at the end, you use up that stream
        int result = nums.stream()
                        .filter(n -> n%4==0)
                        .map(n->(int) Math.pow(n, 2))
                        .reduce(0,(c,n)-> c+n);
        System.out.println(result);

        //Parallel Stream
        int size = 1000;
        List<Integer> nums2 = new ArrayList<>(size);

        Random ran  = new Random();
        for(int i=0; i < size; i++){
            nums2.add(ran.nextInt(100));
        }
        
        long startTime = System.currentTimeMillis();

        int sum = nums2.stream()
                        .map(n -> {
                            try{Thread.sleep(1);}
                            catch(Exception e){
                                System.out.println(e);
                            }
                            return n * 2;
                        })
                        //This gets values and turns it into int
                        .mapToInt(n -> n)
                        .sum();
        long endTime = System.currentTimeMillis();
        
        long startParaTime = System.currentTimeMillis();
        int sum2 = nums2.parallelStream()
                        .map(n -> {
                            try{Thread.sleep(1);}
                            catch(Exception e){
                                System.out.println(e);
                            }
                            return n * 2;
                        })
                        //This gets values and turns it into int
                        .mapToInt(n -> n)
                        .sum();  
        long endParaTime = System.currentTimeMillis();

        System.out.printf("Seq sum: %d\tPara sum: %d\n",sum,sum2);
        System.out.printf("Seq time: %d\nPara time: %d",(endTime-startTime),(endParaTime-startParaTime));

    }

    // Sorting collection with Comparator
    public static void handleCompare() {

        /*
         * 
         * Notes
         * 
         * Using the comparator, we are sorting the values based on the number in the
         * ones place. So answer is [31, 92, 43, 74]
         * 
         * The sort method on Collection takes a Comparator, which compares 2 values and
         * returns a int (1 for greater than, 0 for equal and -1 for less than)
         * to use for deciding the order of the values.
         * 
         * 
         * You can either have a class implement Comparable <T> or you can create a
         * Comparator object and use in the sort method
         * 
         */

        Comparator<Integer> intCom = (Integer o1, Integer o2) -> ((o1 % 10) > (o2 % 10)) ? 1
                : ((o1 % 10) < (o2 % 10)) ? -1 : 0;

        Comparator<String> stringCom = (String s1, String s2) -> s1.length() < s2.length() ? 1
                : s1.length() > s2.length() ? -1 : 0;

        List<Integer> nums = new ArrayList<>();
        nums.add(43);
        nums.add(31);
        nums.add(74);
        nums.add(92);

        List<String> sList = new ArrayList<>();
        sList.add("A");
        sList.add("AB");
        sList.add("ABC");
        sList.add("ABCD");
        sList.add("ABCDE");
        sList.add("ABCDEF");

        Collections.sort(nums, intCom);
        Collections.sort(sList, stringCom);
        System.out.println(nums);
        System.out.println(sList);

    }

    public static void handleMap() {
        Map<String, Integer> students = new HashMap<>();
        students.put("A", 92);
        students.put("B", 89);
        students.put("C", 88);
        students.put("D", 83);

        System.out.println(students.keySet());

        for (String key : students.keySet()) {
            System.out.println(key + ": " + students.get(key));
        }

    }

    public static void handleSet() {
        // Collection of unique values
        Set<Integer> set = new HashSet<Integer>();
        set.add(4);
        set.add(5);
        set.add(5);
        set.add(2);
        set.add(1);

        System.out.println("Set: " + set);

        // Sorted set
        Set<Integer> sortedSet = new TreeSet<Integer>();
        sortedSet.add(4);
        sortedSet.add(5);
        sortedSet.add(5);
        sortedSet.add(2);

        System.out.println("Sorted Set: " + sortedSet);

        Iterator<Integer> values = sortedSet.iterator();

        while (values.hasNext()) {
            System.out.println(values.next());
        }
    }

    public static void handleList() {
        // Array List
        List<Integer> colect = new ArrayList<>();
        colect.add(1);
        colect.add(2);
        System.out.println(colect);
        System.out.println(colect.indexOf(2));

        for (int n : colect) {
            System.out.println(n);
        }
    }
}
