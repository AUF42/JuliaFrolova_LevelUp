package homework_4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class AssertionSteps extends AbstractBaseStep {
    public AssertionSteps(WebDriver driver) {
        super(driver);
    }
    SoftAssert sa = new SoftAssert();

    @Step("Проверка на успешную авторизацию в системе")
    public void assertSuccessLogIn() {
        Assert.assertTrue(driver.getTitle().contains("Входящие"),  "Вы не авторизованы в системе");
    }
    @Step("Проверить, что письмо сохранено в Черновиках")
    public void assertThatMessageInTheDraftFolder() {
        driver.navigate().refresh();
        foldersPage.goToDraftFolder();
        sa.assertEquals(messageSnippetPage.getMsgDestination(), MAIL_DESTINATION, "Отправитель не соответствует destination");
        sa.assertEquals(messageSnippetPage.getMsgTheme(), MAIL_ABSTRACT_THEME, "Тема письма не соответствует theme");
        sa.assertEquals(messageSnippetPage.getMsgContext(),MAIL_ABSTRACT_CONTEXT, "Содержимое письма не соответствует context");
        sa.assertAll();
    }
    @Step ("Проверить, что письмо исчезло из папки Черновики")
    public void assertThatDraftFolderIsClean(){
        foldersPage.goToDraftFolder();
        driver.navigate().refresh();
        sa.assertEquals(foldersPage.getTitleFromDraftFolder(), "Черновики", "Сообщение не было отправлено или была поймана капча");
        sa.assertAll();
    }
    @Step("Проверить, что письмо появилось в папке Отправленные")
    public void assertThatMessageInTheSentFolder() {
        foldersPage.goToSentFolder();
        Assert.assertEquals(messageSnippetPage.getMsgDestination(), MAIL_DESTINATION,"Отправитель не соответсвует destination" );
    }
    @Step("Проверить, что письмо появилось в папке Тест")
    public void assertThatMessageInTheTestFolder() {
        foldersPage.goToTestFolder();
        driver.navigate().refresh();
        sa.assertEquals(messageSnippetPage.getMsgDestination(), MAIL_DESTINATION, "Отправитель не соответсвует destination");
        sa.assertEquals(messageSnippetPage.getMsgTheme(), MAIL_SPECIAL_THEME, "Тема письма не соответствует theme");
        sa.assertEquals(messageSnippetPage.getMsgContext(), MAIL_ABSTRACT_CONTEXT , "Содержимое письма не соответствует context");
        sa.assertAll();
    }
    @Step("Проверить, что письмо в папке Входящие")
    public void assertThatMessageInTheInboxFolder() {
        foldersPage.goToInboxFolder();
        driver.navigate().refresh();
        sa.assertEquals(messageSnippetPage.getMsgDestination(), MAIL_DESTINATION, "Отправитель не соответсвует destination");
        sa.assertEquals(messageSnippetPage.getMsgTheme(), MAIL_ABSTRACT_THEME, "Тема письма не соответствует theme");
        sa.assertEquals(messageSnippetPage.getMsgContext(), MAIL_ABSTRACT_CONTEXT, "Содержимое письма не соответствует context");
        sa.assertAll();
    }
    @Step("Проверить, что письмо в Корзине")
    public void assertThatMessageInTheBasketFolder(){
        foldersPage.goToBasketFolder();
        sa.assertEquals(messageSnippetPage.getMsgDestination(), MAIL_DESTINATION, "Отправитель не соответсвует destination");
        sa.assertAll();
    }
}
