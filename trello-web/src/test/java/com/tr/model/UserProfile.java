package com.tr.model;

import java.io.File;

public class UserProfile {
  String fullName;
  String userName;
  String initials;
  File photo;

  public String getFullName() {
    return fullName;
  }

  public UserProfile withFullName(String fullName) {
    this.fullName = fullName;
    return  this;
  }

  public String getUserName() {
    return userName;
  }

  public UserProfile withUserName(String userName) {
    this.userName = userName;
    return  this;
  }

  public String getInitials() {
    return initials;
  }

  public UserProfile setInitials(String initials) {
    this.initials = initials;
    return  this;
  }

  public File getPhoto() {
    return photo;
  }

  public File setPhoto(File photo) {
    this.photo = photo;
    return photo;
  }

  @Override
  public String toString() {
    return "UserProfile{" +
            "fullName='" + fullName + '\'' +
            ", userName='" + userName + '\'' +
            ", initials='" + initials + '\'' +
            '}';
  }
}
