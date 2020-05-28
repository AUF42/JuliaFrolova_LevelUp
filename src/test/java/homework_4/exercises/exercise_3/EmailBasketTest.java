package homework_4.exercises.exercise_3;

import homework_4.exercises.AbstractBaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
        //Создать новое письмо (заполнить адресата, тему письма и тело)
        bodyMailPage.writeMessage(MAIL_DESTINATION,MAIL_ABSTRACT_THEME,MAIL_ABSTRACT_CONTEXT);
        //Отправить письмо
        bodyMailPage.sendMail();
        //Verify, что письмо появилось в папке Входящие
        foldersPage.goToInboxFolder();
        driver.navigate().refresh();
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(messageSnippetPage.getMsgDestination(), MAIL_DESTINATION, "Отправитель не соответсвует destination");
        //Verify контент, адресата и тему письма
        sa.assertEquals(messageSnippetPage.getMsgTheme(), MAIL_ABSTRACT_THEME, "Тема письма не соответствует theme");
        sa.assertEquals(messageSnippetPage.getMsgContext(), MAIL_ABSTRACT_CONTEXT, "Содержимое письма не соответствует context");
        //Удалить письмо
        foldersPage.deleteAllMailsInFolder();
        //Verify что письмо появилось в папке Корзина
        foldersPage.goToBasketFolder();
        sa.assertEquals(messageSnippetPage.getMsgDestination(), MAIL_DESTINATION, "Отправитель не соответсвует destination");
        sa.assertAll();
        //Удалим все письма из папки "Удаленные"
        foldersPage.deleteAllMailsInFolder();
    }
}