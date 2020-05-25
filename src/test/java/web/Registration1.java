package web;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Registration1 {
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase() throws Exception {
      wd.get("https://creditexchange-uat.tusvc.bcs.ru/");
      wd.findElement(By.xpath("//span[@type='cash']")).click();
      wd.findElement(By.xpath("(//button[@type='button'])[2]")).click();
      wd.findElement(By.id("fullName")).click();
      wd.findElement(By.id("fullName")).clear();
      wd.findElement(By.id("fullName")).sendKeys("Петров Александр Сергеевич");
      wd.findElement(By.id("phone")).click();
      wd.findElement(By.id("phone")).clear();
      wd.findElement(By.id("phone")).sendKeys("9505050503");
      wd.findElement(By.id("email")).click();
      wd.findElement(By.id("email")).clear();
      wd.findElement(By.id("email")).sendKeys("test@testtest.ty");
      wd.findElement(By.xpath("//div/button/span")).click();
      wd.findElement(By.id("sms")).click();
      wd.findElement(By.id("sms")).sendKeys("1234");
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    wd.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
