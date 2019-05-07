package com.tr.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateTeam extends  TestBase {
  @Test
  public  void teamCreationFromHeaderTest() throws InterruptedException {
    app.getHeader().clickOnPlusButtonOnHeader();
    app.getTeamHelper().selectCreateTeamFromDropDown();
    app.getTeamHelper().fillTeamCreationForm("ggg", "desc");
    app.getTeamHelper().submitTeamCreation();

    String teamName = app.getTeamHelper().getTeamName();

    Assert.assertEquals(teamName, "ggg");


  }
}
