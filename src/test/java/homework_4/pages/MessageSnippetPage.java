package homework_4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author u.frolova
 *
 * Класс программы.
 * Описывает элементы в фрагменте письма Яндекс-Почты.
 *
 **/

public class MessageSnippetPage extends BasePage{
    public MessageSnippetPage(WebDriver driver) {
        super(driver);
    }
    // Фрагмент сообщения "Адресат письма"
    @FindBy(xpath = "//span[@class='mail-MessageSnippet-FromText']")
    private WebElement msgDestination;
    // Фрагмент сообщения "Тема письма"
    @FindBy(xpath = "//span[@class='mail-MessageSnippet-Item mail-MessageSnippet-Item_subject']//span")
    private WebElement msgTheme;
    // Фрагмент сообщения "Содержимое письма"
    @FindBy(xpath = "//span[contains(@class,'Item_firstline')]//span")
    private WebElement msgContext;

    /**
     * @return адресата письма
     **/
    public String getMsgDestination(){
        String text = msgDestination.getAttribute("title");
        return text;
    }
    /**
     * @return тему письма
     **/
    public String getMsgTheme(){
        String text = msgTheme.getText();
        return text;
    }
    /**
     * @return содержимое письма
     **/
    public String getMsgContext(){
        String text = msgContext.getText();
        return text;
    }
}
