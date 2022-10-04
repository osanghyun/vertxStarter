package com.kt.vertxStarter.entity;

public class Member {
  private String name;
  private String position;
  private String phoneNo;
  private String part;
  private String role;

  public Member(String name, String position, String phoneNo, String part, String role) {
    this.name = name;
    this.position = position;
    this.phoneNo = phoneNo;
    this.part = part;
    this.role = role;
  }

  @Override
  public String toString() {
    return "Member{" +
      "name : " + name +
      ", position : " + position +
      ", phoneNo : " + phoneNo +
      ", part : " + part +
      ", role : " + role + "}";
  }

  public String getName() {
    return this.name;
  }

  public String getPosition() {
    return this.position;
  }

  public String getPart() {
    return this.part;
  }

  public String getRole() {
    return this.role;
  }

  public String getPhoneNo() {
    return this.phoneNo;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public void setPart(String part) {
    this.part = part;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public void setPhoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
  }

}
