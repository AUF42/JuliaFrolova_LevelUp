package homework_4.exercises;

import homework_4.steps.ActionSteps;
import homework_4.steps.AssertionSteps;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

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
    protected ActionSteps actionSteps;
    protected AssertionSteps assertionSteps;

    protected static final String MAIL_BASE_URL = "https://mail.yandex.ru/";

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(MAIL_BASE_URL);

        actionSteps = new ActionSteps(driver);
        assertionSteps = new AssertionSteps(driver);
    }
    @BeforeMethod
    public void login(){
        actionSteps.logInInMail();
        assertionSteps.assertSuccessLogIn();
        }

    @AfterMethod
    public void logOutMai(){
        actionSteps.logOutMail();
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}

