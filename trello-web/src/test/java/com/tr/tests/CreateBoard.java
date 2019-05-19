package com.tr.tests;

import com.tr.model.Board;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateBoard extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() throws InterruptedException {
    if(!app.getBoardHelper().isOnTheHomePage()){
      app.getHeader().clickOnHomeButtonOnHeader();
  }
  }

  @Test
  public void boardCreationTest() throws InterruptedException {
    int before = app.getBoardHelper().getPersonalBoardsCount();
   // app.getHeader().clickOnPlusButtonOnHeader();
    app.getHeader().waitAndClickOnPlusButtonOnHeader();;
    app.getBoardHelper().selectCreateBoardFromDropDown();
    app.getBoardHelper().fillBoardCreationForm(new Board().withBoardName("Test board"));
    app.getBoardHelper().submitBoardCreation();
//return to home page
    app.getHeader().clickOnHomeButtonOnHeader();
    int after = app.getBoardHelper().getPersonalBoardsCount();

    //verify, board created
    System.out.println(after +"    -   "+ before);

    Assert.assertEquals(after, before+1);

  }
  @Test
  public void boardCcountTest() throws InterruptedException {
    int count = app.getBoardHelper().getPersonalBoardsCount();
    System.out.println( count);

  }

  @Test(enabled = false)
  public void boardLisTest() throws InterruptedException {


    System.out.println(  app.getBoardHelper().getBoardsList());

  }
  @Test(enabled = false)
  public void boardCreationNegativTest() {

  }

}
