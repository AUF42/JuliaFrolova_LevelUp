package homework_4.exercises;

import homework_4.pages.BodyMailPage;
import homework_4.pages.FoldersPage;
import homework_4.pages.LoginPage;
import homework_4.pages.MessageSnippetPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * @author u.frolova
 *
 * Абстрактный класс программы.
 * Инициализирует ВебДрайвер для запуска тестов, и закрывает его после выполнения.
 * Содержит в методе LogInInMail процедуру авторизации в электронном ящике.
 *
 **/

public abstract class AbstractBaseTest {

    protected WebDriver driver;
    protected static final String MAIL_BASE_URL = "https://mail.yandex.ru/";
    protected static final String MAIL_LOGIN = "auf42";
    protected static final String MAIL_PSW = "1234sobakapes";
    protected static final String MAIL_DESTINATION = "auf42@yandex.ru";
    protected static final String MAIL_ABSTRACT_THEME = "Readme";
    protected static final String MAIL_ABSTRACT_CONTEXT = "Readme";
    protected static final String MAIL_SPECIAL_THEME = "Тест";
    protected LoginPage loginPage;
    protected BodyMailPage bodyMailPage;
    protected FoldersPage foldersPage;
    protected MessageSnippetPage messageSnippetPage;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        bodyMailPage = new BodyMailPage(driver);
        foldersPage = new FoldersPage(driver);
        messageSnippetPage = new MessageSnippetPage(driver);
    }

    @BeforeMethod
    public void logInInMail(){
        driver.get(MAIL_BASE_URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPage.loginInMail(MAIL_LOGIN,MAIL_PSW );//AUF42//auf42
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleContains("Входящие"));
        //проверка на совершенную авторизацию в системе
        Assert.assertTrue(driver.getTitle().contains("Входящие"),  "Вы не авторизованы в системе");
    }

    @AfterMethod
    public void logOutInMail(){
        loginPage.logOutFromMail();

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

