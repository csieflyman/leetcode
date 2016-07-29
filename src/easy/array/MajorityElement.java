package easy.array;

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
public class MajorityElement {

    private int[] nums;
    private int expectedResult;

    public MajorityElement(int[] nums, int expectedResult) {
        this.nums = nums;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int [] {1, 2, 2, 2, 1}, 2}, {new int [] {1, 1, 2, 2, 1, 1}, 1}, {new int[] {1,0,0,0,1,0}, 0}
        });

    }

    @Test
    public void testMajorityElement() throws Exception {
        Assert.assertEquals(expectedResult, majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        int half = nums.length / 2 + 1;
        int[][] result = new int[half][2];
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            boolean exist = false;
            int index = 0;
            for (int j = 0; j < count; j++) {
                if(result[j][0] == nums[i]) {
                    exist = true;
                    index = j;
                    break;
                }
            }
            if(!exist) {
                result[count][0] = nums[i];
                result[count][1] = 1;
                count++;
            }
            else {
                result[index][1] = result[index][1] + 1;
                if(result[index][1] > half)
                    return result[index][0];
            }
        }

        for (int i = 0; i < count; i++) {
            if(result[i][1] >= half)
                return result[i][0];
        }
        return -1;
    }
}
