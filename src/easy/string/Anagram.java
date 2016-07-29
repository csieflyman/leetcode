package easy.string;

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
public class Anagram {

    private String s;
    private String t;
    private boolean expectedResult;

    public Anagram(String s, String t, boolean expectedResult) {
        this.s = s;
        this.t = t;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"anagram", "nagaram", true}, {"rat", "car", false},
                {"abcde", "acbde", true},
        });

    }

    @Test
    public void testAnagram() throws Exception {
        Assert.assertEquals(expectedResult, isAnagram(s, t));
        Assert.assertEquals(expectedResult, isAnagramUnicode(s, t));
    }

    public boolean isAnagram(String s, String t) {
        if(s == null || t == null)
            return false;
        if(s.length() != t.length())
            return false;

        int[] result = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int sCodePoint = s.charAt(i) - 97;
            int tCodePoint = t.charAt(i) - 97;
            result[sCodePoint] = result[sCodePoint] + 1;
            result[tCodePoint] = result[tCodePoint] - 1;
        }

        for(int i = 0; i < result.length; i++) {
            if(result[i] != 0)
                return false;
        }
        return true;
    }

    public boolean isAnagramUnicode(String s, String t) {
        if(s == null || t == null)
            return false;
        if(s.length() != t.length())
            return false;

        int[][] result = new int[s.length()][2];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int sCodePoint = s.codePointAt(i);
            boolean exist = false;
            int foundIndex = 0;
            for(int j = 0; j < count; j++) {
                if (result[j][0] == sCodePoint){
                    exist = true;
                    foundIndex = j;
                    break;
                }
            }
            if(exist) {
                result[foundIndex][1] = result[foundIndex][1] + 1;
            }
            else {
                result[count][0] = sCodePoint;
                result[count][1] = 1;
                count++;
            }
        }

        for (int i = 0; i < t.length(); i++) {
            int tCodePoint = t.codePointAt(i);
            boolean exist = false;
            int foundIndex = 0;
            for(int j = 0; j < count; j++) {
                if (result[j][0] == tCodePoint){
                    exist = true;
                    foundIndex = j;
                    break;
                }
            }
            if(exist) {
                result[foundIndex][1] = result[foundIndex][1] - 1;
            }
            else {
                return false;
            }
        }

        for(int i = 0; i < count; i++) {
            if(result[i][1] != 0)
                return false;
        }
        return true;
    }
}
