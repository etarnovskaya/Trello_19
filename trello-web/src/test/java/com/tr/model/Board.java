package com.tr.model;

public class Board {
  private  String boardName;


  public Board withBoardName(String boardName) {
    this.boardName = boardName;
    return this;
  }

  public String getBoardName() {
    return boardName;
  }
}
