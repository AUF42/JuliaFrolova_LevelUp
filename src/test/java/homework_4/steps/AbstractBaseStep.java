package homework_4.steps;

import homework_4.pages.BodyMailPage;
import homework_4.pages.FoldersPage;
import homework_4.pages.LoginPage;
import homework_4.pages.MessageSnippetPage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractBaseStep {

    protected WebDriver driver;

    LoginPage loginPage;
    BodyMailPage bodyMailPage;
    FoldersPage foldersPage;
    MessageSnippetPage messageSnippetPage;

    protected static final String MAIL_LOGIN = "auf42";
    protected static final String MAIL_PSW = "1234sobakapes";
    protected static final String MAIL_DESTINATION = "auf42@yandex.ru";
    protected static final String MAIL_ABSTRACT_THEME = "Readme";
    protected static final String MAIL_ABSTRACT_CONTEXT = "Readme";
    protected static final String MAIL_SPECIAL_THEME = "Тест";


    protected AbstractBaseStep(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
        bodyMailPage = new BodyMailPage(driver);
        foldersPage = new FoldersPage(driver);
        messageSnippetPage = new MessageSnippetPage(driver);
    }
}
