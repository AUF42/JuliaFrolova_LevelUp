package homework_4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author u.frolova
 *
 * Класс программы.
 * Описывает элементы окна редактирования E-Mail Яндекс-Почты.
 *
 **/

public class BodyMailPage extends BasePage{
    public BodyMailPage(WebDriver driver) {
        super(driver);
    }

    // Кнопка "Написать" письмо
    @FindBy(linkText = "Написать")
    private WebElement writeBtn;
    // Поле адресата
    @FindBy(className = "composeYabbles")
    private WebElement destinationField;
    // Поле с темой письма
    @FindBy(name = "subject")
    private WebElement themeField;
    // Поле с содержимым письма
    @FindBy(xpath = "//textarea//..//br")
    private WebElement contextField;
    // Кнопка закрыть
    @FindBy(xpath = "//div[@class='ComposePopup-Head']//button[2]")
    private WebElement closeBodyMailBtn;
    // Письмо в папке "Черновики"
    @FindBy(xpath = "//div[contains(@class,'MessagesList')]")
    private WebElement msgList;
    // Кнопка "Отправить"
    @FindBy(xpath = "//div[contains(@class ,'SendButton')]//button")
    private WebElement sendMailBtn;

    // Написать письмо
    public void writeMessage (String destination, String theme, String context){
        writeBtn.click();
        destinationField.sendKeys(destination);
        themeField.sendKeys(theme);
        contextField.sendKeys(context);
    }
    // Нажать на кнопку "Закрыть"
    public void clickOnCloseBtn () {
        closeBodyMailBtn.click();
    }
    // Отправить письмо из черновиков
    public void sendMailFromDraft() {
        msgList.click();
        sendMailBtn.click();
    }
    // Отправить письмо
    public void sendMail(){
        sendMailBtn.click();
    }
}
