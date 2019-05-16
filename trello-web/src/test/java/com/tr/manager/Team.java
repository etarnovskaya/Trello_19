package com.tr.manager;

public class Team {
  private final String teamName;
  private final String desc;

  public Team(String teamName, String desc) {
    this.teamName = teamName;
    this.desc = desc;
  }

  public String getTeamName() {
    return teamName;
  }

  public String getDesc() {
    return desc;
  }
}
