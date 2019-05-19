package com.tr.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HelperBase {
  WebDriver wd;
  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public void waitForElementAndClick(long timeout, By locator) {
    WebDriverWait wait = new WebDriverWait(wd, timeout);
    wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    wd.findElement(locator).click();
  }

  public void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public boolean isElementPresent(By locator) {
    return wd.findElements(locator).size()>0;
  }

  public boolean isOnTheHomePage() {
    return isElementPresent(By.cssSelector(".content-all-boards"));
  }
}
