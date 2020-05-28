package homework_4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author u.frolova
 *
 * Класс программы.
 * Описывает элементы для авторизация в Яндекс-Почте.
 *
 **/

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    // Кнопка "Войти" на главной странице
    @FindBy (linkText = "Войти")
    private WebElement baseSubmitBtn;
    // Поле для ввода логина
    @FindBy (id = "passp-field-login")
    private WebElement loginField;
    // Поле для ввода пароля
    @FindBy (id = "passp-field-passwd")
    private WebElement pswField;
    // Кнопка "Войти"
    @FindBy (xpath = "//span[text()='Войти']/..")
    private WebElement submitBtn;
    // Иконка пользователя
    @FindBy (className = "user-pic__image")
    private WebElement userIcon;
    // Кнопка "Выйти из сервисов Яндекса"
    @FindBy (linkText = "Выйти из сервисов Яндекса")
    private WebElement logOutBtn;

    //авторизация в системе
    public void loginInMail(String login,String psw) {
        baseSubmitBtn.click();
        loginField.sendKeys(login);
        submitBtn.click();
        pswField.sendKeys(psw);
        submitBtn.click();
    }
    // Выход из почты
    public void logOutFromMail(){
        userIcon.click();
        logOutBtn.click();
    }
}
