import org.junit.Assert;
import org.junit.Test;

public class TestAddition {

    @Test
    public void add() {
        Addition addition = new Addition();
        int sum = addition.add(44, 56);
        Assert.assertEquals(100,sum);
    }
}
