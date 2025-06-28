public class AdvancedCalculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public int div(int a, int b) {
        if (b == 0) throw new ArithmeticException("Divide by zero");
        return a / b;
    }

    public int mod(int a, int b) {
        if (b == 0) throw new ArithmeticException("Divide by zero");
        return a % b;
    }

    public long pow(int base, int exp) {
        return (long) Math.pow(base, exp);
    }

    public double sqrt(int num) {
        return Math.sqrt(num);
    }

    public double log(double num) {
        return Math.log(num);
    }

    public double sin(double degree) {
        return Math.sin(Math.toRadians(degree));
    }

    public double cos(double degree) {
        return Math.cos(Math.toRadians(degree));
    }

    public double tan(double degree) {
        return Math.tan(Math.toRadians(degree));
    }

    public double inverse(double num) {
        if (num == 0) throw new ArithmeticException("Math Error!");
        return 1 / num;
    }
}
