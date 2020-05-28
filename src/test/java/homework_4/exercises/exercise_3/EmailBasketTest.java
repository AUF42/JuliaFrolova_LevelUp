package homework_4.exercises.exercise_3;

import homework_4.exercises.AbstractBaseTest;
import org.testng.annotations.Test;

/**
 * @author u.frolova
 *
 * Класс программы-тест.
 * Проверяет корректность попадания сообщения в папку "Удаленные" при удалении сообщения из входящих.
 *
 **/

public class EmailBasketTest extends AbstractBaseTest {

    @Test
    public void checkBasketAfterSent(){
        actionSteps.writeAbstractMessage();
        actionSteps.sendMessage();
        assertionSteps.assertThatMessageInTheInboxFolder();
        actionSteps.clearFolder();
        assertionSteps.assertThatMessageInTheBasketFolder();
        actionSteps.clearFolder();
    }
}