package com.tr.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class BoardHelper extends  HelperBase {


  public List<Object> getBoardsList() throws InterruptedException {
    Thread.sleep(10000);
    List<Object> boards = new ArrayList<>();
    List<WebElement> pboards = wd.findElements(By.xpath("//span[@class='icon-lg icon-member']/../../..//li"));
    for (WebElement pboard : pboards) {
      String boardName = pboard.findElement(By.xpath(".//*[@class='board-tile-details-name']")).getAttribute("title");
      System.out.println(boardName);
    }


    return boards;
  }

  public BoardHelper(WebDriver wd) {
    super(wd);

  }

  public void submitBoardCreation() {
    click(By.cssSelector("[data-test-id='header-create-board-submit-button']"));
  }

  public void fillBoardCreationForm(String boardName) {
    type(By.cssSelector("[data-test-id='header-create-board-title-input']"), boardName);
  }

  public void selectCreateBoardFromDropDown() {
    click(By.cssSelector("[data-test-id='header-create-board-button']"));
  }

  public int getPersonalBoardsCount() {
    return wd.findElements(By.xpath("//span[@class='icon-lg icon-member']/../../..//li")).size();
  }

  public void clickOnTheFirstPrivateBoard() {

    WebDriverWait wait = new WebDriverWait(wd, 10);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='icon-lg icon-member']/../../..//ul")));

    WebElement personalBoardsCollection = wd.findElement(By.xpath("//span[@class='icon-lg icon-member']/../../..//ul"));
    personalBoardsCollection.findElement(By.xpath(".//*[@class='board-tile']")).click();
  }

  public void openMenu() {

  }

  public void clickOnMoreButton() {
    click(By.cssSelector(".js-open-more"));
  }

  public void clickCloseButton() {
    if (wd.findElements(By.cssSelector(".js-close-board")).size() > 0) {
      click(By.cssSelector(".js-close-board"));
    } else click(By.cssSelector(".js-leave-board"));
  }
}
