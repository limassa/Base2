package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CT04LoginSucesso {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://mantis-prova.base2.com.br/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCT04LoginSucesso() throws Exception {
    driver.get(baseUrl + "/login_page.php");
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("joao.moreira");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("Neto@1991");
    driver.findElement(By.name("perm_login")).click();
    driver.findElement(By.cssSelector("input.button")).click();
    driver.findElement(By.linkText("Report Issue")).click();
    driver.findElement(By.cssSelector("input.button")).click();
    new Select(driver.findElement(By.name("category_id"))).selectByVisibleText("[All Projects] Teste");
    new Select(driver.findElement(By.name("reproducibility"))).selectByVisibleText("always");
    new Select(driver.findElement(By.name("profile_id"))).selectByVisibleText("Desktop Windows 10");
    driver.findElement(By.id("platform")).clear();
    driver.findElement(By.id("platform")).sendKeys("x64");
    driver.findElement(By.id("os")).clear();
    driver.findElement(By.id("os")).sendKeys("Windows 10");
    driver.findElement(By.id("os_build")).clear();
    driver.findElement(By.id("os_build")).sendKeys("Pro");
    driver.findElement(By.name("summary")).clear();
    driver.findElement(By.name("summary")).sendKeys("Teste Base");
    driver.findElement(By.name("description")).clear();
    driver.findElement(By.name("description")).sendKeys("teste de Automação Base 2");
    // ERROR: Caught exception [Error: Dom locators are not implemented yet!]
    driver.findElement(By.cssSelector("input.button")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
