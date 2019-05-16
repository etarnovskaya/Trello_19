package com.tr.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderHelper  extends HelperBase{
  public HeaderHelper(WebDriver wd) {
    super(wd);
  }

  public void clickOnPlusButtonOnHeader() throws InterruptedException {
    Thread.sleep(15000);
    click(By.name("add"));
      }

      public void waitAndClickOnPlusButtonOnHeader() throws InterruptedException {
   waitForElementAndClick(15, By.name("add"));
  //  click(By.name("add"));
      }

      public  void clickOnHomeButtonOnHeader() throws InterruptedException {
    //click(By.cssSelector(".icon-house"));
        Thread.sleep(7000);
        click(By.name("house"));

      }

}
