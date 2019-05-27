package com.tr.tests;

import com.tr.model.Team;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateTeam extends  TestBase {
  @BeforeMethod
  public void ensurePreconditions() throws InterruptedException {
    if(!app.getBoardHelper().isOnTheHomePage()){
      app.getHeader().clickOnHomeButtonOnHeader();
    }
  }
  @Test
  public  void teamCreationFromHeaderTest() throws InterruptedException {
    app.getHeader().clickOnPlusButtonOnHeader();
    app.getTeamHelper().selectCreateTeamFromDropDown();
    String teamName = "ggg " + System.currentTimeMillis();
    app.getTeamHelper().fillTeamCreationForm(new Team().withTeamName(teamName));
    app.getTeamHelper().submitTeamCreation();

    String teamNameActual = app.getTeamHelper().getTeamName();

    Assert.assertEquals(teamNameActual, teamName);


  }
}
