package easy.compute;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author csieflyman
 */
@RunWith(Parameterized.class)
public class AddDigits {

    private int number;
    private int expectedResult;

    public AddDigits(int number, int expectedResult) {
        this.number = number;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {38, 2}, {999, 9}, {55, 1}, {123, 6}
        });
    }

    @Test
    public void testAddDigits() {
        Assert.assertEquals(expectedResult, addDigits(number));
    }

    public int addDigits(int num) {
        if(num < 10)
            return num;
        return addDigits(addDigits(num/10) + num%10);
    }
}
