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
public class PowerOfTwo {

    private int n;
    private boolean expected;

    public PowerOfTwo(int n, boolean expected) {
        this.n = n;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, false}, {1, true}, {2, true}, {3, false}, {4, true}, {8,true}, {10, false}, {16, true}
        });

    }

    @Test
    public void testIsPowerOfTwo() throws Exception {
        Assert.assertEquals(expected, isPowerOfTwo(n));
        Assert.assertEquals(expected, isPowerOfTwo2(n));
    }

    public boolean isPowerOfTwo(int n) {
        return n >= 1 && (n & (n - 1)) == 0;
    }

    public boolean isPowerOfTwo2(int n) {
        if(n <= 0)
            return false;
        int count = 0;
        while(n != 0) {
            if((n & 1) == 1)
                count++;
            n = n >>> 1;
        }
        return count == 1;
    }
}
