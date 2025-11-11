
interface MyCode{

double myScore();

}

public class Test {

public static void main(String[] args) {

MyCode myScore;

myScore = () -> 87;

System.out.println(myScore.myScore());

}

}