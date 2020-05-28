package homework_4.exercises.exercise_2;

import homework_4.exercises.AbstractBaseTest;
import org.testng.annotations.Test;

/**
 * @author u.frolova
 *
 * Класс программы-тест.
 * Проверяет корректность сортировки входящих сообщений по папкам с фильтром.
 *
 **/

public class EmailCheckFilterTest extends AbstractBaseTest {

    @Test
    public void checkMailFilter(){
        actionSteps.writeSpecialMessage();
        actionSteps.sendMessage();
        assertionSteps.assertThatMessageInTheSentFolder();
        assertionSteps.assertThatMessageInTheTestFolder();
        actionSteps.clearFolder();
    }
}
