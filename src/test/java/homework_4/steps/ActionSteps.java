package homework_4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ActionSteps extends AbstractBaseStep {
    public ActionSteps(WebDriver driver) {
        super(driver);
    }

    @Step("Авторизация в почтовом ящике")
    public void logInInMail () {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage.loginInMail(MAIL_LOGIN,MAIL_PSW);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleContains("Входящие"));
    }
    @Step("Выход из почтового ящика")
    public void logOutMail(){
        loginPage.logOutFromMail();
    }
    @Step ("Написать письмо")
    public void writeAbstractMessage(){
        bodyMailPage.writeMessage(MAIL_DESTINATION, MAIL_ABSTRACT_THEME,MAIL_ABSTRACT_CONTEXT);
    }
    @Step ("Написать письмо")
    public void writeSpecialMessage(){
        bodyMailPage.writeMessage(MAIL_DESTINATION, MAIL_SPECIAL_THEME,MAIL_ABSTRACT_CONTEXT);
    }
    @Step ("Сохранить письмо в черновиках")
    public void saveMessageInDraftFolder (){
        bodyMailPage.clickOnCloseBtn();
    }
    @Step ("Отправить письмо из черновиков")
    public void sendMessageFromDraft(){
        bodyMailPage.sendMailFromDraft();
    }
    @Step("Очистить папку от писем")
    public void clearFolder(){
        foldersPage.deleteAllMailsInFolder();
    }
    @Step ("Отправить письмо")
    public void sendMessage(){
        bodyMailPage.sendMail();
    }
}
