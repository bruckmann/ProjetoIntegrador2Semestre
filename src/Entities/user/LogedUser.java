package Entities.user;

public class LogedUser {

  public static User user;

  public void setUser(User user) {
    LogedUser.user = user;
  }

  public User getLoggedUser() {
    return user;
  }


}
