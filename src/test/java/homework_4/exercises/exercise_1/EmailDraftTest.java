package homework_4.exercises.exercise_1;

import homework_4.exercises.AbstractBaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
        //Создать новое письмо (заполнить адресата, тему письма и тело)
        bodyMailPage.writeMessage(MAIL_DESTINATION, MAIL_ABSTRACT_THEME,MAIL_ABSTRACT_CONTEXT);
        //Сохранить его как черновик
        bodyMailPage.clickOnCloseBtn();
        driver.navigate().refresh();
        foldersPage.goToDraftFolder();
        //Verify, что письмо сохранено в черновиках
        //Verify контент, адресата и тему письма
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(messageSnippetPage.getMsgDestination(), MAIL_DESTINATION, "Отправитель не соответствует destination");
        sa.assertEquals(messageSnippetPage.getMsgTheme(), MAIL_ABSTRACT_THEME, "Тема письма не соответствует theme");
        sa.assertEquals(messageSnippetPage.getMsgContext(),MAIL_ABSTRACT_CONTEXT, "Содержимое письма не соответствует context");
        //Отправить письмо
        bodyMailPage.sendMailFromDraft();
        //Verify, что письмо исчезло из черновиков
        foldersPage.goToDraftFolder();
        driver.navigate().refresh();
        sa.assertEquals(foldersPage.getTitleFromDraftFolder(), "Черновики", "Сообщение не было отправлено или была поймана капча");
        sa.assertAll();
        //Assert, что письмо появилось в папке отправленные
        foldersPage.goToSentFolder();
        Assert.assertEquals(messageSnippetPage.getMsgDestination(), MAIL_DESTINATION,"Отправитель не соответсвует destination" );
        //Удалим все письма из папки "Отправленные"
        foldersPage.deleteAllMailsInFolder();
    }
}
