package Repositories.user;

import Entities.user.User;
import Util.Utils;

import java.util.ArrayList;
import java.util.List;

public abstract class UserRepository implements IUserRepository {

  @Override
  public List<User> getUsers() {
    return null;
  }

  @Override
  public abstract User getUserById(int id);

  @Override
  public abstract boolean saveUser(User user);

  @Override
  public abstract boolean deleteUser(int id);

  @Override
  public abstract boolean updateUser(User user);

}