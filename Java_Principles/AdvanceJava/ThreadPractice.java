

class Counter{

    private int counter;

    // Use the synchronized keyword to make sure only one thread at a time using it
    public synchronized void increment(){
        this.counter++;
    }

    public String getCounter(){
        return String.valueOf(this.counter);
    }
}


/*
 * 
 * Notes
 * 
 * Since class A implements runnable and overrides the Run method
 * 
 * Instead of creating the class A like below, you can just create
 * an Anonymous Class when creating Runnable and use that to specify the
 * functionality for the Runnable instance
 * 
 */

class A implements Runnable
{
    public void show(){
        for(int i = 0; i<10;i++){
            System.out.println("h1");
            try{
                Thread.sleep(10);
            }
            catch(Exception e)
            {
                System.out.println("Exception...." + e);
            }
        }
    }

    @Override
    public void run(){
        this.show();;
    }
}

class B implements Runnable
{
    public void show(){
        for(int i = 0; i<10;i++){
            System.out.println("hello");
            try
            {
                Thread.sleep(10);
            }
            catch(Exception e)
            {
                System.out.println("Exception...." + e);
            }
            }
    }

    @Override
    public void run(){
        this.show();
    }
}




public class ThreadPractice {
    public static void main(String[] args){

        Counter c = new Counter();

        Runnable obj1 = () -> {
            for(int i = 0; i<10000;i++){
                try{
                    c.increment();
                }
                catch(Exception e)
                {
                    System.out.println("Exception...." + e);
                }
            }
        };
        Runnable obj2 = () -> {
             for(int i = 0; i<10000;i++){
                try{
                    c.increment();
                }
                catch(Exception e)
                {
                    System.out.println("Exception...." + e);
                }
            }
        };

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

        System.out.println(c.getCounter());
    }
}
