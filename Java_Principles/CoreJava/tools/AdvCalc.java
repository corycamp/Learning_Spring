package tools;

public class AdvCalc extends Calc {

    protected int result;

    public AdvCalc() {
        result = 29;
    }

    public double multi(int num1, int num2) {
        return num1 * num2;
    }

    public double div(int num1, int num2) {
        double result = num1 / num2;
        return num2 != 0 ? result : 0;
    }
}
