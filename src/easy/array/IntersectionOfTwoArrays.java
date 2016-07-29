package easy.array;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author csieflyman
 * https://leetcode.com/problems/intersection-of-two-arrays/
 */
@RunWith(Parameterized.class)
public class IntersectionOfTwoArrays {

    private int[] nums1;
    private int[] nums2;
    private int[] expected;

    public IntersectionOfTwoArrays(int[] nums1, int[] nums2, int[] expected) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[] {1, 2, 2, 1}, new int[] {2, 2}, new int[] {2}},
                {new int[] {1, 2, 2, 1}, new int[] {1, 2, 2, 1}, new int[] {1, 2}},
                {new int[] {1, 2, 2, 1}, new int[] {3, 4}, new int[] {}},
                {new int[] {1, 2, 3, 4}, new int[] {1, 2, 3, 4}, new int[] {1, 2, 3, 4}}
        });
    }

    @Test
    public void testIntersection() throws Exception {
        Assert.assertArrayEquals(expected, intersection(nums1, nums2));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] smallNums = length1 < length2 ? nums1 : nums2;
        int[] largeNums = length1 < length2 ? nums2 : nums1;
        int[] intersectNums = new int[smallNums.length];
        int intersectionCount = 0;

        for(int i = 0; i < smallNums.length; i++) {
            for (int j = 0; j < largeNums.length; j++) {
                if(smallNums[i] == largeNums[j]) {
                    boolean isExist = false;
                    for(int k = 0; k < intersectionCount; k++) {
                        if(smallNums[i] == intersectNums[k]) {
                            isExist = true;
                            break;
                        }
                    }
                    if(!isExist) {
                        intersectNums[intersectionCount] = smallNums[i];
                        intersectionCount++;
                    }
                }
            }
        }
        int[] result = Arrays.copyOf(intersectNums, intersectionCount);
        return result;
    }
}
