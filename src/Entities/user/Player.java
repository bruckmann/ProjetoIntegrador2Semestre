package Entities.user;

public class Player extends User {

  private String username;
  private String grade;
  private boolean tdah;


  public Player(int player_id, String name, String password, int age,  String grade, boolean tdah) {
    super(player_id, name, password, age);
    this.grade = grade;
    this.tdah = tdah;
  }


  public String getGrade() {
    return this.grade;
  }



  public boolean getTdah() {
    return this.tdah;
  }

  public void setTdah(boolean tdah) {
    this.tdah = tdah;
  }

  @Override
  public void setGrade(String grade) {
    this.grade = grade;
  }

  @Override
  public void setUsername(String username) {
    this.username = username;
  }



}



