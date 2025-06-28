import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AdvancedCalculatorTest {
    private static AdvancedCalculator calculator;

    @BeforeAll
    public static void initCalculator() {
        System.out.println("Before Test: Initializing calculator object!");
        calculator = new AdvancedCalculator();
    }

    @AfterAll
    public static void destroyCalculator() {
        System.out.println("After Test: Destroying calculator object!");
        calculator = null;
    }

    @Test
    public void additionTest() {
        int a = 54, b = 33;
        int result = calculator.add(a, b);
        Assertions.assertEquals(87, result);
    }

    @Test
    public void subtractionTest() {
        int a = 54, b = 33;
        int result = calculator.sub(a, b);
        Assertions.assertEquals(21, result);
    }

    @Test
    public void multiplicationTest() {
        int a = 5, b = 30;
        int result = calculator.mul(a, b);
        Assertions.assertEquals(150, result);
    }

    @Test
    public void divisionTest() {
        int a = 54, b = 18;
        int result = calculator.div(a, b);
        Assertions.assertEquals(3, result);

        ArithmeticException exception = Assertions.assertThrows(ArithmeticException.class, () -> calculator.div(a, 0));
        Assertions.assertEquals("Divide by zero", exception.getMessage());
    }

    @Test
    public void moduloTest() {
        int a = 54, b = 5;
        int result = calculator.mod(a, b);
        Assertions.assertEquals(4, result);
    }

    @ParameterizedTest
    @CsvSource({"2, 4", "3, 4"})
    public void powerTest(int base, int exp) {
        long res = calculator.pow(base, exp);
        Assertions.assertEquals(Math.pow(base,exp), res);
    }

    @Test
    public void sqrt() {
        int num = 100;
        Assertions.assertEquals(10, calculator.sqrt(num));
    }

    @Test
    public void log() {
        int num = 49;
        Assertions.assertEquals(Math.log(num), calculator.log(num));
    }

    @Test
    public void sin() {
        int deg = 30;
        Assertions.assertEquals(Math.sin(Math.toRadians(deg)), calculator.sin(deg));
    }

    @Test
    public void cos() {
        int deg = 30;
        Assertions.assertEquals(Math.cos(Math.toRadians(deg)), calculator.cos(deg));
    }

    @Test
    public void tan() {
        int deg = 45;
        Assertions.assertEquals(Math.tan(Math.toRadians(deg)), calculator.tan(deg));
    }

    @Test
    public void inverse() {
        int num = 32;
        Assertions.assertEquals((double) 1 / num, calculator.inverse(num));
    }
}
