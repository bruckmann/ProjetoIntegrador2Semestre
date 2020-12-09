package Entities.user;

public class LoggedUser {

  public static User user;

  public void setUser(User user) {    LoggedUser.user = user;
  }

  public User getLoggedUser() {
    return user;
  }


}
