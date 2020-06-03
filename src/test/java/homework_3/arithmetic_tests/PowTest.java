package homework_3.arithmetic_tests;

import homework_3.AbstractBaseTest;
import homework_3.DataProvidersForTests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author u.frolova
 *
 * Тест на корректность возведения числа в степень программой Калькулятор.
 *
 **/

public class PowTest extends AbstractBaseTest {

    @Test(dataProvider = "PowData", dataProviderClass = DataProvidersForTests.class)
    public void pow(double a, double b, double expectedResult) {
        System.out.println("Возведение числа в степень: " + a + " ^ " +b + " = " + expectedResult);
        Assert.assertEquals(calculator.pow(a,b), expectedResult, 0.001, "В программе ошибка, проверьте формулу вычисления pow");
    }
}
