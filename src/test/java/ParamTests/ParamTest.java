package ParamTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;


public class ParamTest {
    WebDriver driver;
    @Test
    @Parameters({"enteringString", "checkingString"})
    public void testCompareStrings(@Optional("Кто такой кук") String enteringString,@Optional("Кто такой кук") String checkingString) {
System.setProperty("webdriver.chrome.driver", "src/test/java/ParamTests/resourses/chromedriver");
driver = new ChromeDriver();
driver.get("https://google.com");
        WebElement search = driver.findElement(By.xpath("//input[@title=\"Поиск\"]"));
        search.sendKeys(enteringString);
        WebElement table = driver.findElement(By.xpath("//div[@class='erkvQe']"));
        String a = table.getText();
        Assert.assertTrue(a.contains(checkingString));
        driver.quit();
    }


//    String driver = "src/test/java/ParamTests/resourses/chromedriver";
//    @Test
//    @Parameters("searchKey")
//
//    public void testLogin(String searchKey) {
//        System.out.printf("Check login with browser");
//    }
}
