package Repositories.user;

import Entities.questions.Question;
import Entities.user.Player;
import Entities.user.User;
import Util.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlayerRepository extends UserRepository{


  @Override
  public List<User> getUsers() {
    List<User> players = new ArrayList<>();
    final String query = "SELECT * FROM jogador ORDER BY id_jogador";
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    try {
      connection = ConnectionFactory.getConnection();
      statement = connection.createStatement();
      resultSet = statement.executeQuery(query);
      while (resultSet.next()) {
        User player = new Player();
        player.setId(resultSet.getInt("id_jogador"));
        player.setName(resultSet.getString("nome"));
        player.setCriador(resultSet.getInt("id_criador"));
        player.setType(resultSet.getInt("id_tipo"));
        players.add(player);
        return players;
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (statement != null) {
          statement.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return players;
  }


  @Override
  public boolean saveUser(User player) {
    try {
      playerList.add(player);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public boolean deleteUser(int id) {
    User player = this.getUserById(id);
    playerList.remove(player);
  }

  @Override
  public boolean updateUser(User updatePlayer) {
    User player = this.getUserById(updatePlayer.getId());
    playerList.remove(player);
    playerList.add(updatePlayer);
  }

}
