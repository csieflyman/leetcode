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
public class NumberOf1Bits {

    private int n;
    private int expected;

    public NumberOf1Bits(int n, int expected) {
        this.n = n;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {11, 3}
        });

    }

    @Test
    public void testHammingWeight() throws Exception {
        Assert.assertEquals(expected, hammingWeight(n));
    }

    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            if((n & 1) == 1)
                count++;
            n >>>= 1;
        }
        return count;
    }
}
