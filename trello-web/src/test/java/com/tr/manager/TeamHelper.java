package com.tr.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static jdk.nashorn.internal.objects.NativeJava.type;

public class TeamHelper {
  WebDriver wd;
  public TeamHelper(WebDriver wd) {
    this.wd = wd;
  }

  public void selectCreateTeamFromDropDown() {
  //  click(By.cssSelector(".js-new-org"));
    click(By.cssSelector("[data-test-id='header-create-team-button']"));
  }

  public void fillTeamCreationForm(String teamName, String desc) {
    //name
   // type(By.name("displayName"), teamName);
type(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamName);

//desc
  type(By.name("desc"), desc);

  }

  public void submitTeamCreation() {
    click(By.cssSelector("[type=submit]"));
  }

  public String getTeamName() throws InterruptedException {
    Thread.sleep(10000);
    return  wd.findElement(By.cssSelector("h1.u-inline")).getText();
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

}
