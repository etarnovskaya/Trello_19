package com.tr.model;

public class Team {
  private  String teamName;
  private  String desc;


  public Team withTeamName(String teamName) {
    this.teamName = teamName;
    return  this;
  }

  public Team withDesc(String desc) {
    this.desc = desc;
    return  this;
  }

  public String getTeamName() {
    return teamName;
  }

  public String getDesc() {
    return desc;
  }

}
