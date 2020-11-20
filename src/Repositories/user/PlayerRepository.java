package Repositories.user;

import Entities.user.User;
import java.util.ArrayList;
import java.util.List;

public class PlayerRepository extends UserRepository{

  private static List<User> playerList = new ArrayList<>();

  public List<User> getUsers() {
    return playerList;
  }

  @Override
  public User getUserById(int id) {
    for (User player : playerList) {
      if (player.getId() == id) {
        try {
          return player;
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
    return null;
  }

  public void saveUser(User player) {
    try {
      playerList.add(player);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void deleteUser(int id) {
    User player = this.getUserById(id);
    playerList.remove(player);
  }

  @Override
  public void updateUser(User updatePlayer) {
    User player = this.getUserById(updatePlayer.getId());
    playerList.remove(player);
    playerList.add(updatePlayer);
  }

}
