package homework_3.arithmetic_tests;

import homework_3.AbstractBaseTest;
import homework_3.DataProvidersForTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubTest extends AbstractBaseTest {
    @Test(dataProvider = "SubLongData", dataProviderClass = DataProvidersForTests.class)
    public void sub(long a, long b, long expectedResult)
    {
        System.out.println("Вычисление разности чисел: " + a + "-" + b +  " = " + expectedResult);
        Assert.assertEquals(calculator.sub(a,b), expectedResult,"В программе ошибка, проверьте формулу вычисления sub");
    }

    @Test(dataProvider = "SubDoubleData", dataProviderClass = DataProvidersForTests.class)
    public void sub(double a, double b, double expectedResult)
    {
        System.out.println("Вычисление разности чисел: " + a + "-" + b +  " = " + expectedResult);
        Assert.assertEquals(calculator.sub(a,b), expectedResult, "В программе ошибка, проверьте формулу вычисления sub");
    }
}
