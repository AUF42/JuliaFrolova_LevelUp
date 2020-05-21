package homework_4.exercise_3;

import homework_4.AbstractBaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * @author u.frolova
 *
 * Класс программы-тест.
 * Проверяет корректность попадания сообщения в папку "Удаленные" при удалении сообщения из входящих.
 *
 **/

public class EmailBasketTest extends AbstractBaseTest {
    String destination = "auf42@yandex.ru";
    String theme = "Readme";
    String context = "Readme";

    @Test
    public void checkBasketAfterSent(){
        //Создать новое письмо (заполнить адресата, тему письма и тело)
        driver.findElement(By.linkText("Написать")).click();
        driver.findElement(By.className("composeYabbles")).sendKeys(destination);
        driver.findElement(By.name("subject")).sendKeys(theme);
        driver.findElement(By.xpath("//textarea//..//br")).sendKeys(context);
        //Отправить письмо
        driver.findElement(By.xpath("//div[contains(@class ,'SendButton')]//button")).click();
        //Verify, что письмо появилось в папке Входящие
        driver.findElement(By.linkText("Вернуться во \"Входящие\"")).click();
        driver.navigate().refresh();
        SoftAssert sa = new SoftAssert();
        sa.assertEquals((driver.findElement(By.xpath("//span[@class='mail-MessageSnippet-FromText']"))).
                getAttribute("title"), destination, "Отправитель не соответсвует destination");
        //Verify контент, адресата и тему письма
        sa.assertEquals((driver.findElement(By.xpath("//span[@class='mail-MessageSnippet-Item mail-MessageSnippet-Item_subject']//span"))).
                getText(), theme, "Тема письма не соответствует theme");
        sa.assertEquals((driver.findElement(By.xpath("//span[contains(@class,'Item_firstline')]//span"))).
                getText(), context, "Содержимое письма не соответствует context");
        //Удалить письмо
        driver.findElement(By.xpath("//span[@class='checkbox_view']")).click();
        driver.findElement(By.xpath("//div[@title='Удалить (Delete)']")).click();
        //Verify что письмо появилось в папке Корзина
        driver.findElement(By.xpath("//a[@data-title='Удалённые']")).click();
        sa.assertEquals((driver.findElement(By.xpath("//span[@class='mail-MessageSnippet-FromText']"))).
                getAttribute("title"), destination, "Отправитель не соответсвует destination");
        sa.assertAll();
        //Удалим все письма из папки "Удаленные"
        driver.findElement(By.xpath("//span[@class='checkbox_view']")).click();
        driver.findElement(By.xpath("//div[@title='Удалить (Delete)']")).click();
    }
}