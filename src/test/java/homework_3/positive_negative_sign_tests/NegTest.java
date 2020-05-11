package homework_3.positive_negative_sign_tests;

import homework_3.AbstractBaseTest;
import homework_3.DataProvidersForTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegTest extends AbstractBaseTest {

    @Test(dataProvider = "NegativeData", dataProviderClass = DataProvidersForTests.class)
    public void NegativeData(long a, Boolean expectedResult)
    {
        System.out.println("Данное число отрицательное? " + a  +  " = " + expectedResult);
        Assert.assertTrue(calculator.isNegative(a), "Число положительное или равно 0");
    }
}
