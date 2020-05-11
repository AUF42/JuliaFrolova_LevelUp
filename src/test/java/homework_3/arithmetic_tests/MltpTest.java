package homework_3.arithmetic_tests;

import homework_3.AbstractBaseTest;
import homework_3.DataProvidersForTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MltpTest extends AbstractBaseTest {

    @Test(dataProvider = "MtplLongData", dataProviderClass = DataProvidersForTests.class)
    public void mult(long a, long b, long expectedResult)
    {
        System.out.println("Произведение чисел: : " + a + " / " +b + " = " + expectedResult);
        Assert.assertEquals(calculator.mult(a,b), expectedResult);
    }

    @Test(dataProvider = "MtplDoubleData", dataProviderClass = DataProvidersForTests.class)
    public void mult(double a, double b, double expectedResult)
    {
        System.out.println("Произведение чисел: : " + a + " / " +b + " = " + expectedResult);
        Assert.assertEquals(calculator.mult(a,b), Math.floor(expectedResult), "В программе ошибка, проверьте формулу вычисления mult");
    }
}
