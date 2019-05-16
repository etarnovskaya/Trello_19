package com.tr.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteBoardTests extends  TestBase{
  @Test
  public void firstPrivateBoardDeletionTest() throws InterruptedException {
   // int before = app.getBoardHelper().getPersonalBoardsCount();

    app.getBoardHelper().clickOnTheFirstPrivateBoard();
    app.getBoardHelper().openMenu();
   app.getBoardHelper().clickOnMoreButton();
   app.getBoardHelper().clickCloseButton();
//    app.getBoardHelper().confirmCloseButton();
//    app.getBoardHelper().clickPermanentlyDelete();
//    app.getBoardHelper().confirmPermanentlyDelete();
//    app.getHeader().clickOnHomeButtonOnHeader();
//
//    int after = app.getBoardHelper().getPersonalBoardsCount();

//    Assert.assertEquals(after, before-1);


  }
}
