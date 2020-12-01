package Entities.user;

public class Admin extends User {


  public Admin(int admin_id, String name,  String password, int age, String email){
    super(admin_id, name,  password, age, email);
  }

  public String getEmail() {
    return super.getEmail();
  }

  @Override
  public void setTdah(boolean tdah) {

  }

  @Override
  public void setGrade(String grade) {

  }

  @Override
  public void setUsername(String username) {

  }

}
