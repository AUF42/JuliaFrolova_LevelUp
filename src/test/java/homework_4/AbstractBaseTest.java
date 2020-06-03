package homework_4;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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

    public WebDriver driver;


    @BeforeMethod
        public void LogInInMail(){
        String login = "auf42";
        String psw = "1234sobakapes";

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mail.yandex.ru/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Войти")).click();
        driver.findElement(By.id("passp-field-login")).sendKeys(login);//AUF42//auf42
        driver.findElement(By.xpath("//span[text()='Войти']/..")).click();
        driver.findElement(By.id("passp-field-passwd")).sendKeys(psw);
        driver.findElement(By.xpath("//span[text()='Войти']/..")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleContains("Входящие"));
        //проверка на совершенную авторизацию в системе
        Assert.assertTrue(driver.getTitle().contains("Входящие"),  "Вы не авторизованы в системе");
       }


    @AfterMethod
    public void LogOutInMail(){
        driver.findElement(By.className("user-pic__image")).click();
        driver.findElement(By.linkText("Выйти из сервисов Яндекса")).click();
        driver.quit();
    }
}

