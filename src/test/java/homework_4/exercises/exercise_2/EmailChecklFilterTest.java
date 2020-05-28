package homework_4.exercises.exercise_2;

import homework_4.exercises.AbstractBaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

/**
 * @author u.frolova
 *
 * Класс программы-тест.
 * Проверяет корректность сортировки входящих сообщений по папкам с фильтром.
 *
 **/

public class EmailChecklFilterTest extends AbstractBaseTest {

    @Test
    public void checkMailFilter(){
        //Создать новое письмо (заполнить адресата, тему письма и тело)
        bodyMailPage.writeMessage(MAIL_DESTINATION,MAIL_SPECIAL_THEME,MAIL_ABSTRACT_CONTEXT);
        //Отправить письмо
        bodyMailPage.sendMail();
        //Verify, что письмо появилось в папке отправленные
        foldersPage.goToSentFolder();
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(messageSnippetPage.getMsgDestination(), MAIL_DESTINATION, "Письмо не было отправлено");
        //Verify, что письмо появилось в папке «Тест»
        foldersPage.goToTestFolder();
        sa.assertEquals(messageSnippetPage.getMsgDestination(), MAIL_DESTINATION, "Отправитель не соответсвует destination");
        //Verify контент, адресата и тему письма
        sa.assertEquals(messageSnippetPage.getMsgTheme(), MAIL_SPECIAL_THEME, "Тема письма не соответствует theme");
        sa.assertEquals(messageSnippetPage.getMsgContext(), MAIL_ABSTRACT_CONTEXT , "Содержимое письма не соответствует context");
        sa.assertAll();
        //Удалим все письма из папки "Тест
        driver.navigate().refresh();
        foldersPage.deleteAllMailsInFolder();
    }
}
