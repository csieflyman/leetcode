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
public class MoveZeroes {

    private int[] nums;
    private int[] expectedResult;

    public MoveZeroes(int[] nums, int[] expectedResult) {
        this.nums = nums;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[] {0, 1, 0, 3, 12}, new int[] {1, 3, 12, 0, 0}},
                {new int[] {1, 2, 3, 4, 5}, new int[] {1, 2, 3, 4, 5}},
                {new int[] {0, 0, 0, 0, 0}, new int[] {0, 0, 0, 0, 0}}
        });

    }

    @Test
    public void testMoveZeroes() throws Exception {
        moveZeroes(nums);
        Assert.assertArrayEquals(expectedResult, nums);
    }

    public void moveZeroes(int[] nums) {
        int zeroCounts = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0)
                zeroCounts++;
            else {
                nums[i - zeroCounts] = nums[i];
            }
        }
        for(int i = (nums.length - zeroCounts); i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}