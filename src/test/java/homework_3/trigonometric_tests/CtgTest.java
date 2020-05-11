package homework_3.trigonometric_tests;

import homework_3.AbstractBaseTest;
import homework_3.DataProvidersForTests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author u.frolova
 *
 * Тест на корректность вычисления котангенса числа программой Калькулятор.
 *
 **/

public class CtgTest extends AbstractBaseTest {

    @Test(dataProvider = "CtgData", dataProviderClass = DataProvidersForTests.class)
    public void ctg(double a, double expectedResult)
    {
        System.out.println("Котангенс числа: " + a  +  " = " + expectedResult);
        Assert.assertEquals(calculator.ctg(a), expectedResult,0.001,"В программе ошибка, проверьте формулу вычисления ctg");
    }
}

