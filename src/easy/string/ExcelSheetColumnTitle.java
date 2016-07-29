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
public class ExcelSheetColumnTitle {

    private int n;
    private String expectedResult;

    public ExcelSheetColumnTitle(int n, String expectedResult) {
        this.n = n;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, "A"}, {26, "Z"}, {27, "AA"}, {52, "AZ"}, {53, "BA"}, {78, "BZ"}, {79, "CA"}, {1000000001, "CFDGSXM"}
        });

    }

    public String convertToTitle(int n) {
        if(n <= 26)
            return String.valueOf((char) (65 + (n - 1) % 26));
        return convertToTitle((n - 1) / 26) + (char) (65 + (n - 1) % 26) ;
    }

    @Test
    public void testConvertToTitle() throws Exception {
        Assert.assertEquals(expectedResult, convertToTitle(n));
    }
}
