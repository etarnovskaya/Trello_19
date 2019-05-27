package com.tr.tests;

import com.tr.model.UserProfile;
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

  @Test
  public void testAddPhoto() throws InterruptedException {
    app.getUser().clickOnAvatar();
    app.getUser().clickProfileFromDropDown();
    app.getUser().initChahgePhoto();
    File file = new File("src/test/resources/cat_small.png" );
    app.getUser().attachPicture(new UserProfile().setPhoto(file));
    //app.getUser().attachPicture(new File("src/test/resources/cat_small.png"));

    Thread.sleep(10000);

  }

}
