package com.tr.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateTeam extends  TestBase {
  @Test
  public  void teamCreationFromHeaderTest() throws InterruptedException {
    app.getHeader().clickOnPlusButtonOnHeader();
    app.getTeamHelper().selectCreateTeamFromDropDown();
    String teamName = "ggg " + System.currentTimeMillis();
    app.getTeamHelper().fillTeamCreationForm(teamName, "desc");
    app.getTeamHelper().submitTeamCreation();

    String teamNameActual = app.getTeamHelper().getTeamName();

    Assert.assertEquals(teamNameActual, teamName);


  }
}
