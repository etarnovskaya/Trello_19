package com.tr.tests;

import com.tr.model.UserProfile;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserProfileModification extends  TestBase {
  @DataProvider
  public Iterator<Object[]> profile(){
    List<Object[]> list = new ArrayList<>();
    list.add(new Object[]{"telran1", "etarnovskaya1", "IB"});
    list.add(new Object[]{"telran2", "etarnovskaya2", "II"});
    list.add(new Object[]{"nametelran3", "etarnovskaya3", "Ij"});
    list.add(new Object[]{"telran4", "etarnovskaya4", "Im"});

    return list.iterator();
  }

  @Test(dataProvider = "profile")
  public void testProfileModificationDataProvider(String userName, String fullName, String initials) throws InterruptedException {
    UserProfile userProfile = new UserProfile()
            .withUserName(userName)
            .withFullName(fullName)
            .withInitials(initials);
    app.getUser().clickOnAvatar();
    app.getUser().clickProfileFromDropDown();
    app.getUser().initProfileModification();
    app.getUser().fillProfileForm(userProfile);
    app.getUser().submitModification();
    app.screenshot();
    app.getHeader().clickOnHomeButtonOnHeader();
  }
  @Test(enabled = false)
          public void testProfileModification() throws InterruptedException {
    app.getUser().clickOnAvatar();
    app.getUser().clickProfileFromDropDown();
    app.getUser().initProfileModification();
    app.getUser().fillProfileForm(new UserProfile()
            .withFullName("kkk")
            .withUserName("hhh")
            .withInitials("em"));
    app.getUser().submitModification();
  }



}
