package com.tr.tests;

import com.tr.manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

  public static class MyListener extends AbstractWebDriverEventListener{
    Logger logger = LoggerFactory.getLogger(TestBase.class);


    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
      logger.info("Start to search element " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
      logger.info(by + " found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
      app.screenshot();
      logger.error("!!!!!!! ERROR !!!!!!! " , throwable );
    }
  }

  Logger logger = LoggerFactory.getLogger(TestBase.class);

  protected static ApplicationManager app = new ApplicationManager
          (System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite
    public void setUp(){
    app.start();

  }

  @BeforeMethod
  public void logTestStart(Method m, Object[] parameter){
    logger.info("Start test " + m.getName() + " with parameters " + Arrays.asList(parameter));

  }

  @AfterMethod
  public void logTestStop(Method m){
    logger.info("Stop test " + m.getName());
  }

  @AfterSuite
  public  void tearDown(){
    app.stop();
  }

}
