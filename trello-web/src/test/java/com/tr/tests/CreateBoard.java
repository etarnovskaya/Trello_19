package com.tr.tests;

import com.tr.model.Board;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateBoard extends TestBase {
  @DataProvider
  public Iterator<Object[]>  boards() throws IOException {
    List<Object[]> list=new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/boards.csv")));
    String line = reader.readLine();
    while (line!=null){
      String[] split =line.split(";");
      list.add(new Object[]{new Board().withBoardName(split[0])});
      line =reader.readLine();
    }
    return list.iterator();
  }

  @BeforeMethod
  public void ensurePreconditions() throws InterruptedException {
    if (!app.getBoardHelper().isOnTheHomePage()) {
      app.getHeader().clickOnHomeButtonOnHeader();
    }
  }

  @Test(dataProvider = "boards")
  public void boardCreationTest(Board board) throws InterruptedException {
    int before = app.getBoardHelper().getPersonalBoardsCount();
    // app.getHeader().clickOnPlusButtonOnHeader();
    app.getHeader().waitAndClickOnPlusButtonOnHeader();
    ;
    app.getBoardHelper().selectCreateBoardFromDropDown();
    app.getBoardHelper().fillBoardCreationForm(board);

    app.getBoardHelper().submitBoardCreation();
//return to home page
    app.getHeader().clickOnHomeButtonOnHeader();
    int after = app.getBoardHelper().getPersonalBoardsCount();

    //verify, board created
    System.out.println(after + "    -   " + before);

    Assert.assertEquals(after, before + 1);

  }

  @Test(enabled = false)
  public void boardCcountTest() throws InterruptedException {
    int count = app.getBoardHelper().getPersonalBoardsCount();
    System.out.println(count);

  }

  @Test(enabled = false)
  public void boardLisTest() throws InterruptedException {


    System.out.println(app.getBoardHelper().getBoardsList());

  }

  @Test(enabled = false)
  public void boardCreationNegativTest() {

  }

}
