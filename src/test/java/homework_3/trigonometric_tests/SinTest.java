package homework_3.trigonometric_tests;

import homework_3.AbstractBaseTest;
import homework_3.DataProvidersForTests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author u.frolova
 *
 * Тест на корректность вычисления синуса числа программой Калькулятор.
 *
 **/

public class SinTest extends AbstractBaseTest {

    @Test(dataProvider = "SinData", dataProviderClass = DataProvidersForTests.class)
    public void sin(double a, double expectedResult)
    {
        System.out.println("Синус числа: " + a  +  " = " + expectedResult);
        Assert.assertEquals(calculator.sin(a), expectedResult,0.001,"В программе ошибка, проверьте формулу вычисления sin");
    }
}
