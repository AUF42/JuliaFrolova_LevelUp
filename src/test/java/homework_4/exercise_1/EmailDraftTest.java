package homework_4.exercise_1;

import homework_4.AbstractBaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * @author u.frolova
 *
 * Класс программы-тест.
 * Проверяет сохранение сообщения в черновиках, и его отправку оттуда.
 *
 **/

public class EmailDraftTest extends AbstractBaseTest {
    String destination = "auf42@yandex.ru";
    String theme = "Readme";
    String context = "Readme";

    @Test
    public void sendMailFromDraft(){
        //Создать новое письмо (заполнить адресата, тему письма и тело)
        driver.findElement(By.linkText("Написать")).click();
        driver.findElement(By.className("composeYabbles")).sendKeys(destination);
        driver.findElement(By.name("subject")).sendKeys(theme);
        driver.findElement(By.xpath("//textarea//..//br")).sendKeys(context);
        //Сохранить его как черновик
        driver.findElement(By.xpath("//div[@class='ComposePopup-Head']//button[2]")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@data-title='Черновики']")).click();
        //Verify, что письмо сохранено в черновиках
        //Verify контент, адресата и тему письма
        SoftAssert sa = new SoftAssert();
        sa.assertEquals((driver.findElement(By.xpath("//span[@class='mail-MessageSnippet-FromText']"))).
                getAttribute("title"), destination, "Отправитель не соответсвует destination");
        sa.assertEquals((driver.findElement(By.xpath("//span[@class='mail-MessageSnippet-Item mail-MessageSnippet-Item_subject']//span"))).
                getText(), theme, "Тема письма не соответствует theme");
        sa.assertEquals((driver.findElement(By.xpath("//span[contains(@class,'Item_firstline')]//span"))).
                getText(), context, "Содержимое письма не соответствует context");
        //Отправить письмо
        driver.findElement(By.xpath("//div[contains(@class,'MessagesList')]")).click();
        driver.findElement(By.xpath("//div[contains(@class ,'SendButton')]//button")).click();
        driver.findElement(By.linkText("Черновики")).click();
        driver.navigate().refresh();
        //Verify, что письмо исчезло из черновиков
        sa.assertEquals((driver.findElement(By.linkText("Черновики")).
                getAttribute("title")), "Черновики", "Сообщение не было отправлено или была поймана капча");
        sa.assertAll();
        //Assert, что письмо появилось в папке отправленные
        driver.findElement(By.linkText("Отправленные")).click();
        Assert.assertEquals((driver.findElement(By.xpath("//span[@class='mail-MessageSnippet-FromText']"))).
                getAttribute("title"), destination,"Отправитель не соответсвует destination" );
        //Удалим все письма из папки "Отправленные"
        driver.findElement(By.xpath("//span[@class='checkbox_view']")).click();
        driver.findElement(By.xpath("//div[@title='Удалить (Delete)']")).click();
    }
}
