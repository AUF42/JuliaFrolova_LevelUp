package homework_3.arithmetic_tests;

import homework_3.AbstractBaseTest;
import homework_3.DataProvidersForTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DivTest extends AbstractBaseTest {

    @Test(dataProvider = "DivLongData", dataProviderClass = DataProvidersForTests.class)
    public void div (long a, long b,  double expectedResult)
    {
        System.out.println("Частное от деления чисел: " + a + " / " +b + " = " + expectedResult);
        Assert.assertEquals(calculator.div(a,b), expectedResult, "В программе ошибка, проверьте формулу вычисления div");
    }

   @Test(dataProvider = "DivDoubleData", dataProviderClass = DataProvidersForTests.class)
    public void div(double a, double b, double expectedResult)
    {
        System.out.println("Частное от деления чисел: " + a + " / " +b + " = " + expectedResult);
        Assert.assertEquals(calculator.div(a,b), expectedResult, "В программе ошибка, проверьте формулу вычисления div");
    }
}
