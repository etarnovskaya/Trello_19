package com.tr.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderHelper  extends HelperBase{
  public HeaderHelper(WebDriver wd) {
    super(wd);
  }

//  public void clickOnPlusButtonOnHeader() throws InterruptedException {
//    Thread.sleep(15000);
//
//    if(isElementPresent(By.cssSelector("[data-test-id=\"header-create-menu-button\"]"))){
//      click(By.cssSelector("[data-test-id=header-create-menu-button]"));
//    } else
//      click(By.cssSelector(".js-open-add-menu"));
//      }

      public void waitAndClickOnPlusButtonOnHeader() throws InterruptedException {
    Thread.sleep(10000);
    if(isElementPresent(By.cssSelector("[data-test-id=\"header-create-menu-button\"]"))){
      click(By.cssSelector("[data-test-id=header-create-menu-button]"));
    } else
click(By.cssSelector(".js-open-add-menu"));
  // waitForElementAndClick(15, By.name("add"));
  //  click(By.name("add"));
      }

      public  void clickOnHomeButtonOnHeader() throws InterruptedException {
        Thread.sleep(7000);
        if(isElementPresent(By.cssSelector(".icon-house"))){
          click(By.cssSelector(".icon-house"));
        } else
        click(By.name("house"));

      }



}
