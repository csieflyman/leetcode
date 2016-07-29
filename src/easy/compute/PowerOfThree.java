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
public class PowerOfThree {

    private int n;
    private boolean expected;

    public PowerOfThree(int n, boolean expected) {
        this.n = n;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, false}, {1, true}, {2, false}, {3, true}, {6, false}, {7, false}, {8, false}, {9, true}, {27, true}
        });

    }

    @Test
    public void testIsPowerOfThree() throws Exception {
        Assert.assertEquals(expected, isPowerOfThree(n));
    }

    public boolean isPowerOfThree(int n) {
        if(n <= 0)
            return false;

        while(n != 1) {
            if((n % 3) != 0)
                return false;
            n = n / 3;
        }
        return true;
    }
}
