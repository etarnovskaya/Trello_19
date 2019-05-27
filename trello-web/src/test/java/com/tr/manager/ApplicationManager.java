package com.tr.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  TeamHelper teamHelper;
  BoardHelper boardHelper;
  HeaderHelper header;
  UserHelper user;
  WebDriver wd;
  private String browser;

  public ApplicationManager(String browser) {
    this.browser = browser;
  }

  public void start() {
    //open browser
    if(browser.equals(BrowserType.FIREFOX)){
      wd = new FirefoxDriver();
    }else  if(browser.equals(BrowserType.CHROME)){
      wd = new ChromeDriver();
    }else if (browser.equals(BrowserType.EDGE)){
      wd = new EdgeDriver();
    }

    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS );
    wd.manage().window().maximize();

    openSite("https://trello.com/");
    user = new UserHelper(wd);
    login("tel.ran@hotmail.com", "Selenium3");
    boardHelper = new BoardHelper(wd);
    teamHelper = new TeamHelper(wd);
    header = new HeaderHelper(wd);
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

  public void stop() {
    wd.quit();
  }

  public BoardHelper getBoardHelper() {
    return boardHelper;
  }

  public TeamHelper getTeamHelper() {
    return teamHelper;
  }

  public HeaderHelper getHeader() {
    return header;
  }

  public UserHelper getUser() {
    return user;
  }
}
