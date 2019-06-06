package com.tr.tests;

import com.tr.model.Board;
import com.tr.model.Team;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateTeam extends  TestBase {
  @DataProvider
  public Iterator<Object[]> teams() throws IOException {
    List<Object[]> list=new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/teams.csv")));
    String line = reader.readLine();
    while (line!=null){
      String[] split =line.split(";");
      list.add(new Object[]{new Team().withTeamName(split[0]).withDesc(split[1])});
      line =reader.readLine();
    }
    return list.iterator();
  }

  @BeforeMethod
  public void ensurePreconditions() throws InterruptedException {
    if(!app.getBoardHelper().isOnTheHomePage()){
      app.getHeader().clickOnHomeButtonOnHeader();
    }
  }
  @Test
  public  void teamCreationFromHeaderTest() throws InterruptedException {
    app.getHeader().waitAndClickOnPlusButtonOnHeader();
    app.getTeamHelper().selectCreateTeamFromDropDown();
   String teamName = "ggg " + System.currentTimeMillis();
    app.getTeamHelper().fillTeamCreationForm(new Team().withTeamName(teamName));
    app.getTeamHelper().submitTeamCreation();

    String teamNameActual = app.getTeamHelper().getTeamName();

  Assert.assertEquals(teamNameActual, teamName);


  }
}
