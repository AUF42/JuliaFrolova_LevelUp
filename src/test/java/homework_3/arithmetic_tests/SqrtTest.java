package homework_3.arithmetic_tests;

import homework_3.AbstractBaseTest;
import homework_3.DataProvidersForTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SqrtTest extends AbstractBaseTest {

    @Test(dataProvider = "SqrtData", dataProviderClass = DataProvidersForTests.class)
    public void sqrt(double a, double expectedResult)
    {
        System.out.println("Вычисление квадратного корня: " + a + " = " + expectedResult);
        Assert.assertEquals(calculator.sqrt(a), expectedResult,  0.001,"В программе ошибка, проверьте формулу вычисления sqrt");
    }
}
