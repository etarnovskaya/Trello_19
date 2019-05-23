package com.tr.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class AddPhotoToProfile  extends  TestBase{
  @BeforeMethod
  public void ensurePreconditions() throws InterruptedException {
    if (!app.getBoardHelper().isOnTheHomePage()) {
      app.getHeader().clickOnHomeButtonOnHeader();
    }
  }
//hhkjhjkhjkhjkhjk
  @Test
  public void testAddPhoto() throws InterruptedException {
    //click on avatar
    app.getUser().clickOnAvatar();
    //clickprofile
    app.getUser().clickProfileFromDropDown();

    //clickChangeProto
    app.getUser().clickChangePhoto();
    File file = new File("src/test/resources/cat_small.png" );
    app.getUser().attachPicture(file);

    Thread.sleep(10000);

    //uploadPicture


  }

}
