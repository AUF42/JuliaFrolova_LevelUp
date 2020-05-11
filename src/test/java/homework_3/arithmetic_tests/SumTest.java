package homework_3.arithmetic_tests;

import homework_3.AbstractBaseTest;
import homework_3.DataProvidersForTests;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SumTest extends AbstractBaseTest {

    @Test(dataProvider = "SumLongData", dataProviderClass = DataProvidersForTests.class)
    public void sum(long a, long b, long expectedResult)
    {
        System.out.println("Вычисление суммы чисел: " + a + "+" + b +  " = " + expectedResult);
        Assert.assertEquals(calculator.sum(a,b), expectedResult,"В программе ошибка, проверьте формулу вычисления sum");
    }

    @Test(dataProvider = "SumDoubleData", dataProviderClass = DataProvidersForTests.class)
    public void sum(double a, double b, double expectedResult)
    {
        System.out.println("Вычисление суммы чисел: " + a + "+" + b +  " = " + expectedResult);
        Assert.assertEquals(calculator.sum(a,b), expectedResult, "В программе ошибка, проверьте формулу вычисления sum");
    }
}
