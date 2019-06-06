package com.tr.manager;

import com.tr.model.Team;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamHelper  extends  HelperBase{


  public TeamHelper(WebDriver wd) {
    super(wd);
  }

  public void selectCreateTeamFromDropDown() {
    if(isElementPresent((long) 10, By.cssSelector(".js-new-org"))){
      click(By.cssSelector(".js-new-org"));
    } else
      waitForElementAndClick(15, By.cssSelector("[data-test-id='header-create-team-button']"));

  }

  public void fillTeamCreationForm(Team team) {
    if(isElementPresent(By.cssSelector("[data-test-id='header-create-team-name-input']"))){
      type(By.cssSelector("[data-test-id='header-create-team-name-input']"),   team.getTeamName());;
    }else
    //name
   type(By.name("displayName"), team.getTeamName());
//type(By.cssSelector("[data-test-id='header-create-team-name-input']"), team.getTeamName());

//desc

  type(By.name("desc"), team.getDesc());

  }

  public void submitTeamCreation() {
    click(By.cssSelector("[type=submit]"));
  }

  public String getTeamName() throws InterruptedException {
    Thread.sleep(10000);
    return  wd.findElement(By.cssSelector("h1.u-inline")).getText();
  }

}
