package com.tr.tests;

import org.testng.annotations.Test;

public class CreateBoard extends TestBase {

  @Test
  public void boardCreationTest() throws InterruptedException {
    app.getHeader().clickOnPlusButtonOnHeader();
    app.getBoardHelper().selectCreateBoardFromDropDown();
    app.getBoardHelper().fillBoardCreationForm("Test board");
    app.getBoardHelper().submitBoardCreation();

    //verify, board created

  }

  @Test(enabled = false)
  public void boardCreationNegativTest() {

  }

}
