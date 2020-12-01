package Entities.user;

public class Player extends User {

  private String username;
  private String grade;
  private boolean tdah;

  public Player(int player_id, String name, String username, String password, int age,  String grade, boolean tdah) {
    super(player_id, name, password, age);
    this.grade = grade;
    this.tdah = tdah;
    this.username = username;
  }

  public String getGrade() {
    return this.grade;
  }

  public void setTdah(boolean tdah) {
    this.tdah = tdah;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }

  public void setUserName(String username) {
    this.username = username;
  }

  public boolean getTdah() {
    return this.tdah;
  }


}
