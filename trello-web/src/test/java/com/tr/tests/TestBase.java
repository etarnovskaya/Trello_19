package com.tr.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
  WebDriver wd;

  @BeforeClass
    public void setUp(){
    //open browser
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS );
    wd.manage().window().maximize();

    openSite("https://trello.com/");
    login("elena.telran@yahoo.com", "12345.com");
    }

  public void submitBoardCreation() {
    click(By.cssSelector("[data-test-id='header-create-board-submit-button']"));
  }

  public void fillBoardCreationForm(String boardName) {
    type(By.cssSelector("[data-test-id='header-create-board-title-input']"), boardName);
  }

  public void selectCreateBoardFromDropDown() {
    click(By.cssSelector("[data-test-id='header-create-board-button']"));
  }

  public void clickOnPlusButtonOnHeader() throws InterruptedException {
    Thread.sleep(15000);
    click(By.name("add"));
  }

  public void openSite(String url) {
    wd.get(url);
  }

  public void login(String userName, String password) {
    click(By.cssSelector("[href='/login']"));
    type(By.name("user"), userName);
    type(By.name("password"), password);

    click(By.id("login"));
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  @AfterClass
  public  void tearDown(){
    wd.quit();
  }
}
