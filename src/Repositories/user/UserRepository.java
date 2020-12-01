package Repositories.user;

import Entities.user.User;
import Util.Utils;

import java.util.ArrayList;
import java.util.List;

public abstract class UserRepository  {

  public List<User> getUsers() {
    return null;
  }

  public abstract User getUserById(int id);

  public abstract void saveUser(User user);

  public abstract void deleteUser(int id);

  public abstract void updateUser(User user);

}