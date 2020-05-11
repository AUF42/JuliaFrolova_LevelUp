package homework_3.trigonometric_tests;

import homework_3.AbstractBaseTest;
import homework_3.DataProvidersForTests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author u.frolova
 *
 * Тест на корректность вычисления тангенса числа программой Калькулятор.
 *
 **/

public class TgTest extends AbstractBaseTest {

    @Test(dataProvider = "TgData", dataProviderClass = DataProvidersForTests.class)
    public void tg(double a, double expectedResult)
    {
        System.out.println("Тангенс числа: " + a  +  " = " + expectedResult);
        Assert.assertEquals(calculator.tg(a), expectedResult, 0.001, "В программе ошибка, проверьте формулу вычисления tg");
    }
}
