package easy.string;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author csieflyman
 */
public class ReverseString {

    @Test
    public void testReverseString() {
        Assert.assertEquals(reverseString("abcde"), "edcba");
        Assert.assertEquals(reverseString("abcdef"), "fedcba");
        Assert.assertEquals(reverseString(""), "");
    }

    public String reverseString(String s) {
        char[] charArray = s.toCharArray();
        for(int i = 0, j = charArray.length -1; i < j; i++, j--) {
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
        }
        return new String(charArray);
    }
}
