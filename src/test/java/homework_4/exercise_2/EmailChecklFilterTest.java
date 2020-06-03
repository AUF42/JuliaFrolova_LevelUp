package homework_4.exercise_2;

import homework_4.AbstractBaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

/**
 * @author u.frolova
 *
 * Класс программы-тест.
 * Проверяет корректность сортировки входящих сообщений по папкам с фильтром.
 *
 **/

public class EmailChecklFilterTest extends AbstractBaseTest {
    String destination = "auf42@yandex.ru";
    String theme = "Тест";
    String context = "Readme";

    @Test
    public void checkMailFilter(){
        //Создать новое письмо (заполнить адресата, тему письма и тело)
        driver.findElement(By.linkText("Написать")).click();
        driver.findElement(By.className("composeYabbles")).sendKeys(destination);
        driver.findElement(By.name("subject")).sendKeys(theme);
        driver.findElement(By.xpath("//textarea//..//br")).sendKeys(context);
        //Отправить письмо
        driver.findElement(By.xpath("//div[contains(@class ,'SendButton')]//button")).click();
        //Verify, что письмо появилось в папке отправленные
        driver.findElement(By.linkText("Отправленные")).click();
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SoftAssert sa = new SoftAssert();
        sa.assertEquals((driver.findElement(By.xpath("//span[@class='mail-MessageSnippet-FromText']"))).
                getAttribute("title"), destination, "Письмо не было отправлено");
        //Verify, что письмо появилось в папке «Тест»
        driver.findElement(By.xpath("//a[@data-title='Тест']")).click();
        sa.assertEquals((driver.findElement(By.xpath("//span[@class='mail-MessageSnippet-FromText']"))).
                getAttribute("title"), destination, "Отправитель не соответсвует destination");
        //Verify контент, адресата и тему письма
        sa.assertEquals((driver.findElement(By.xpath("//span[@class='mail-MessageSnippet-Item mail-MessageSnippet-Item_subject']//span"))).
                getText(), theme, "Тема письма не соответствует theme");
        sa.assertEquals((driver.findElement(By.xpath("//span[contains(@class,'Item_firstline')]//span"))).
                getText(), context, "Содержимое письма не соответствует context");
        sa.assertAll();
        //Удалим все письма из папки "Тест
        driver.navigate().refresh();
        driver.findElement(By.xpath("//span[@class='checkbox_view']")).click();
        driver.findElement(By.xpath("//div[@title='Удалить (Delete)']")).click();
    }
}
