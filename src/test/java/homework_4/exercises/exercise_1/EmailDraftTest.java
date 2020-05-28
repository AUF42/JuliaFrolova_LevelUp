package homework_4.exercises.exercise_1;

import homework_4.exercises.AbstractBaseTest;
import org.testng.annotations.Test;

/**
 * @author u.frolova
 *
 * Класс программы-тест.
 * Проверяет сохранение сообщения в черновиках, и его отправку оттуда.
 *
 **/

public class EmailDraftTest extends AbstractBaseTest {

    @Test
    public void sendMailFromDraft(){
        actionSteps.writeAbstractMessage();
        actionSteps.saveMessageInDraftFolder();
        assertionSteps.assertThatMessageInTheDraftFolder();
        actionSteps.sendMessageFromDraft();
        assertionSteps.assertThatDraftFolderIsClean();
        assertionSteps.assertThatMessageInTheSentFolder();
        actionSteps.clearFolder();
    }
}
