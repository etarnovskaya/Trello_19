package com.tr.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

public class UserHelper  extends HelperBase{
  public UserHelper(WebDriver wd) {
    super(wd);
  }

  public void clickOnAvatar() {
    click(By.cssSelector("[class=member]"));
    }

  public void clickProfileFromDropDown() {
    click(By.cssSelector("a.js-profile"));
  }

  public boolean isThereAnAvatar(){
    return  isElementPresent(By.cssSelector(".profile-image-image"));
  }


  public void clickChangePhoto() {
    initChahgePhoto();
    if (isThereAnAvatar()){
      WebElement profileAvatar = wd.findElement(By.cssSelector(".profile-image-image"));
      WebElement changePic =  wd.findElement(By.cssSelector(".profile-image-change-text"));
      new Actions(wd).moveToElement(profileAvatar).pause(5).click(changePic).perform();
      click(By.cssSelector(".js-no-avatar"));
      waitForElement(10,By.cssSelector(".profile-image-initials") );

      // remove avatar
    }
    //
    waitForElement(10,By.cssSelector(".profile-image-initials") );
    WebElement profileAvatar = wd.findElement(By.cssSelector(".profile-image-initials"));
    WebElement changePic =  wd.findElement(By.cssSelector(".profile-image-change-text"));
    new Actions(wd).moveToElement(profileAvatar).pause(5).click(changePic).perform();

  }

  public void initChahgePhoto(){
    if(isElementPresent(By.cssSelector(".profile-image-initials"))){
      WebElement profileAvatarIn = wd.findElement(By.cssSelector(".profile-image-initials"));
      WebElement changePicIn =  wd.findElement(By.cssSelector(".profile-image-change-text"));
      new Actions(wd).moveToElement(profileAvatarIn).pause(2).click(changePicIn).perform();
    }
    else {
      WebElement profileAvatar = wd.findElement(By.cssSelector(".profile-image-image"));
      WebElement changePic =  wd.findElement(By.cssSelector(".profile-image-change-text"));
       new Actions(wd).moveToElement(profileAvatar).pause(2).click(changePic).perform();


    }
  }

  public void attachPicture(File file) {
    waitForElement(10, By.cssSelector(".js-upload-avatar"));
    attach(By.cssSelector(".js-upload-avatar"), file);
  }
}
