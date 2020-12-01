package Repositories.user;

import Entities.user.User;

import java.util.ArrayList;
import java.util.List;

public class AdminRepository extends UserRepository {

  private static List<User> adminList = new ArrayList<>();

  public List<User> getUsers() {
    return adminList;
  }

  @Override
  public User getUserById(int id) {
    for (User admin : adminList) {
      if (admin.getId() == id) {
        try {
          return admin;
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
    return null;
  }

  public void saveUser(User admin) {
    try {
      adminList.add(admin);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  @Override
  public void deleteUser(int id) {
    User player = this.getUserById(id);
    adminList.remove(player);
  }

  @Override
  public void updateUser(User updateAdmin) {
    User player = this.getUserById(updateAdmin.getId());
    adminList.remove(player);
    adminList.add(updateAdmin);
  }

}