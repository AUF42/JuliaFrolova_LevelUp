package homework_3.trigonometric_tests;

import homework_3.AbstractBaseTest;
import homework_3.DataProvidersForTests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author u.frolova
 *
 * Тест на корректность вычисления косинуса числа программой Калькулятор.
 *
 **/

public class CosTest extends AbstractBaseTest {

    @Test(dataProvider = "CosData", dataProviderClass = DataProvidersForTests.class)
    public void cos(double a, double expectedResult)
    {
        System.out.println("Косинус числа: " + a  +  " = " + expectedResult);
        Assert.assertEquals(calculator.cos(a), expectedResult,0.001,"В программе ошибка, проверьте формулу вычисления sin");
    }
}
