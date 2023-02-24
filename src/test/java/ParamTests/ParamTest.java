package ParamTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;


public class ParamTest {
    WebDriver driver;
    @Test
    @Parameters({"enteringString", "checkingString"})
    public void testCompareStrings(String enteringString,String checkingString) {
System.setProperty("webdriver.chrome.driver", "src/test/java/ParamTests/resourses/chromedriver");
driver = new ChromeDriver();
driver.get("https://google.com");
        WebElement search = driver.findElement(By.xpath("//input[@title=\"Поиск\"]"));
        search.sendKeys(enteringString);
        WebElement table = driver.findElement(By.xpath("//div[@class='erkvQe']"));
        String a = table.getText();
        if (a.contains(checkingString)) {
            driver.quit();
        } else {
            System.out.println("Такого выражения в предложенном списке не было :" + checkingString);
            driver.quit();
        }
    }
}
