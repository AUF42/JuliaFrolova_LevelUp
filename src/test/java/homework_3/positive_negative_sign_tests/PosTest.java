package homework_3.positive_negative_sign_tests;

import homework_3.AbstractBaseTest;
import homework_3.DataProvidersForTests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author u.frolova
 *
 * Тест на корректность определения отрицательного знака числа программой Калькулятор.
 *
 **/

public class PosTest extends AbstractBaseTest {

    @Test(dataProvider = "PositiveData", dataProviderClass = DataProvidersForTests.class)
    public void PositiveData(long a, Boolean expectedResult) {
        System.out.println("Данное число положительное? " + a  +  " = " + expectedResult);
        Assert.assertTrue(calculator.isPositive(a), "Число отрицательное или равно 0");
    }
}
