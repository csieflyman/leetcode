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
public class ExcelSheetColumnNumber {

    private String s;
    private int expectedResult;

    public ExcelSheetColumnNumber(String s, int expectedResult) {
        this.s = s;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"A", 1}, {"Z", 26}, {"AA", 27}, {"AZ", 52}, {"BA", 53}, {"BZ", 78}, {"CA", 79}, {"CFDGSXM", 1000000001}
        });

    }

    @Test
    public void testTitleToNumber() throws Exception {
        Assert.assertEquals(expectedResult, titleToNumber(s));
    }

    public int titleToNumber(String s) {
        if(s.length() == 1)
            return s.charAt(0) - 64;
        int c = s.charAt(s.length() - 1);
        return ((c - 64) % 27)  + 26 * titleToNumber(s.substring(0, s.length() - 1));
    }

    public String convertToTitle(int n) {
        if(n <= 26)
            return String.valueOf((char) (65 + (n - 1) % 26));
        return convertToTitle((n - 1) / 26) + (char) (65 + (n - 1) % 26) ;
    }
}
