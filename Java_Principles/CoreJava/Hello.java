
public class Hello {

    /*
     * Notes
     * 
     * int x = 5;
     * int y = 10;
     * int z = (x++ > 5 && y-- < 10) ? x-- : y;
     * 
     * after this x = 6 and y = 10. Post increment happens
     * after evaluation meaning that 5 > 5 is what is tested.
     * And since that is false, only x++ gets done due to short
     * circuiting. So x becomes 6 and y stays 10.
     */

    public static void main(String[] args) {
        // ternaryOperator();
        // switchStatement();
        // loops();
        // test();
        // arr();
        stringbuff();
    }

    public static void stringbuff() {
        StringBuffer sb = new StringBuffer("1234");
        sb.trimToSize();
        System.out.println(sb.capacity());
        System.out.println(sb.length());

    }

    public static void arr() {
        // Declaring arrays
        // int num[] = {1,2,3};
        // int num2[] = new int[4];

        // declaring multi-dimensional array
        int multiNum[][] = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                multiNum[i][j] = (int) (Math.random() * 10);
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(multiNum[i][j]);
            }
        }

    }

    public static void test() {
        // TODO: Print numbers 1 to 5 using for loop
        int i = 0;
        for (; i < 5; i++) {
            if (i == 0)
                System.out.print("For Loop: " + (i + 1));
            else
                System.out.print(" " + (i + 1));
        }

        // TODO: Print numbers 1 to 5 using while loop
        i = 0;
        while (i < 5) {
            if (i == 0) {
                System.out.println("");
                System.out.print("While Loop: " + (i + 1));
            } else {
                System.out.print(" " + (i + 1));
            }
            i++;
        }

        // TODO: Print numbers 1 to 5 using do-while loop
        i = 0;
        do {
            if (i == 0) {
                System.out.println("");
                System.out.print("Do-While Loop: " + (i + 1));
            } else {
                System.out.print(" " + (i + 1));
            }
            i++;
        } while (i < 5);
    }

    public static void loops() {
        int i = 1;
        int n = 1;

        System.out.println("WHILE");
        // While loop
        while (i < 10) {
            System.out.println("Value: " + i);
            i++;
        }

        System.out.println("DO WHILE");
        i = 0;
        // do while
        do {
            System.out.println("Value: " + i);
            i++;
        } while (i < 4);

        i = 0;

        System.out.println("FOR LOOP");
        // for loop
        for (i = 5; i < 10; i++) {
            System.out.println("Value: " + i);
        }
    }

    public static void switchStatement() {
        int n = 1;

        /*
         * Once a switch statement is seen as true, it will try
         * and run all of them following ones. That is why a break
         * is used.
         */

        switch (n) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
    }

    public static void ternaryOperator() {
        int n = 4;
        int result = 0;

        // Regular approach
        if (n % 2 == 0)
            result = 10;
        else
            result = 20;

        // Ternary approach
        result = n % 2 == 0 ? 10 : 20;

        System.out.println(result);
    }
}