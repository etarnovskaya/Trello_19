package com.tr.tests;

import org.testng.annotations.Test;

public class MoveCard extends TestBase{
  @Test
  public  void  mc(){
    app.getBoardHelper().clickOnTheFirstPrivateBoard();

  }
}
