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
public class PowerOfFour {

    private int num;
    private boolean expected;

    public PowerOfFour(int num, boolean expected) {
        this.num = num;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, false}, {1, true}, {2, false}, {3, false}, {4, true}, {5, false}, {6, false}, {7, false}, {8, false}, {16, true}, {64, true}
        });

    }

    @Test
    public void testIsPowerOfFour() throws Exception {
        Assert.assertEquals(expected, isPowerOfFour2(num));
    }

    public boolean isPowerOfFour(int num) {
        while(num>1){
            if((num & 11) != 0) return false;
            num>>=2;
        }
        return num==1;
    }

    public boolean isPowerOfFour2(int num) {
        if(num <= 0)
            return false;

        int index = 0;
        int count = 0;
        while(num != 0) {
            if((num & 1) == 1) {
                count++;
            }
            if(count >= 2)
                return false;
            num = num >>> 1;
            index++;
        }
        return index % 2 == 1;
    }

    public boolean isPowerOfFour3(int num) {
        if(num <= 0)
            return false;
        while(num != 1) {
            if((num % 4) != 0)
                return false;
            num = num / 4;
        }
        return true;
    }
}
