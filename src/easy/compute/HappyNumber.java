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
public class HappyNumber {

    private int n;
    private boolean expected;

    public HappyNumber(int n, boolean expected) {
        this.n = n;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, true}, {7, true}, {8, false}, {13, true}, {14, false}, {19, true}, {23, true}, {28, true}
        });

    }

    @Test
    public void testIsHappy() throws Exception {
        Assert.assertEquals(expected, isHappy(n));
    }

    public boolean isHappy(int n) {
        if(n == 1 || n == 7)
            return true;
        else if (n < 10)
            return false;

        int sum = 0;
        while(n > 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return isHappy(sum);
    }
}
