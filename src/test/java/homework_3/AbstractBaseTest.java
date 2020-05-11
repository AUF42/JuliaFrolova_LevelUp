package homework_3;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


/**
 * @author u.frolova
 *
 * Абстрактный класс программы.
 * Инициализирует Калькулятор на момент выполнения сьюта.
 *
 **/

public abstract class AbstractBaseTest {

    public static Calculator calculator;

    @BeforeSuite
    public void setUpCalculator() {
        calculator = new Calculator();
    }

    @AfterSuite
    public void tearDownCalculator(){
        calculator = null;
    }
}
