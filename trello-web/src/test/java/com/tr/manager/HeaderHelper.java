package com.tr.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderHelper {
  WebDriver wd;
  public HeaderHelper(WebDriver wd) {
    this.wd = wd;
  }
  public void clickOnPlusButtonOnHeader() throws InterruptedException {
    Thread.sleep(15000);
    click(By.name("add"));
      }
  public void click(By locator) {
    wd.findElement(locator).click();
  }
}
