package homework_4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author u.frolova
 *
 * Класс программы.
 * Описывает элементы - папки Яндекс-Почты.
 *
 **/

public class FoldersPage extends BasePage{
    public FoldersPage(WebDriver driver) {
        super(driver);
    }
    // Папка "Черновики"
    @FindBy(xpath = "//a[@data-title='Черновики']")
    private WebElement draftFolder;
    // Папка "Отправленные"
    @FindBy(linkText = "Отправленные")
    private WebElement sentFolder;
    // Чекбокс "выделить все"
    @FindBy(xpath = "//span[@class='checkbox_view']")
    private WebElement selectAllChbx;
    // Кнопка "Удалить"
    @FindBy(xpath = "//div[@title='Удалить (Delete)']")
    private WebElement deleteBtn;
    // Папка "Тест"
    @FindBy(xpath = "//a[@data-title='Тест']")
    private WebElement testFolder;
    // Папка "Входящие"
    @FindBy(linkText = "Вернуться во \"Входящие\"")
    private WebElement inboxFolder;
    // Папка "Удаленные"
    @FindBy(xpath = "//a[@data-title='Удалённые']")
    private WebElement basketFolder;

    // перейти в папку "Черновики"
    public void goToDraftFolder(){
        draftFolder.click();
    }
    // перейти в папку "Отправленные"
    public void goToSentFolder(){
        sentFolder.click();
    }
    // удалить все в папке
    public void deleteAllMailsInFolder(){
        selectAllChbx.click();
        deleteBtn.click();
    }
    /**
     * @return аттрибуты
     **/
    // получить аттрибуты папки Черновики (для ассерта)
    public String getTitleFromDraftFolder(){
       String text = draftFolder.getAttribute("title");
       return text;
    }
    // перейти в папку "Тест"
    public void goToTestFolder(){
        testFolder.click();
    }
    // перейти в папку "Входящие"
    public void goToInboxFolder(){
        inboxFolder.click();
    }
    // перейти в папку "Удаленные"
    public void goToBasketFolder(){
        basketFolder.click();
    }
}
