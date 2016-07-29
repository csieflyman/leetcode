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
public class ContainsDuplicate {

    private int[] nums;
    private boolean expectedResult;

    public ContainsDuplicate(int[] nums, boolean expectedResult) {
        this.nums = nums;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[] {1,2,3,4,5}, false},{new int[] {1,1,2,3,4}, true}
        });

    }

    @Test
    public void testContainsDuplicate() throws Exception {
        Assert.assertEquals(expectedResult, containsDuplicate(nums));
    }

    // Time Limit Exceed
    public boolean containsDuplicate(int[] nums) {
        if(nums.length == 1)
            return false;

        for (int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }
}
