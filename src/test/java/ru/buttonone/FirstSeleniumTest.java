package ru.buttonone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FirstSeleniumTest {

    @Test
    public void shouldHaveCorrectToOpenGoogle() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.navigate().to("http://www.google.com/");
//        driver.navigate().to("http://vk.com");
//        driver.navigate().back();
//        driver.navigate().forward();
//        driver.navigate().refresh();

        WebElement searchField = driver.findElement(By.cssSelector("body input[name='q']"));
        searchField.click();

        searchField.sendKeys("java");
        searchField.sendKeys(Keys.RETURN);

        WebElement linkToJavaOracle
                = driver.findElement(By.xpath("//h3[text()= 'Java (programming language) - Wikipedia']"));

        linkToJavaOracle.click();
        WebElement articleTitleFromWiki
                = driver.findElement(By.xpath("//span[@class='mw-page-title-main']"));

        Assertions.assertEquals("Java (programming language)"
                , articleTitleFromWiki.getText());

        //        WebElement textUnderPage = driver.findElement(By.id("SIvCob"));
//        System.out.println(textUnderPage.getText());


//        Assertions.assertEquals("Сервисы Google доступны на этих языках: ภาษาไทย English",
//                textUnderPage.getText() );

//        List<WebElement> menuList = driver.findElements(By.className("pHiOh"));
//        for (WebElement we: menuList) {
//            System.out.println(we.getText());
//        }

//        WebElement element = driver.findElement(By.tagName("input"));
//        System.out.println(element.getText());

        driver.quit();
    }
}
