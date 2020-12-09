package Repositories.user;

import Entities.questions.Alternative;
import Entities.user.Admin;
import Entities.user.User;
import Util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminRepository extends UserRepository {

  private static List<User> adminList = new ArrayList<>();

  public List<User> getUsers() {
    return adminList;
  }

  @Override
  public List<User> getUserByEmail(String emailLogin) {
    List<User> loggedUser = new ArrayList<>();
    final String admQuery = "SELECT * FROM  administrador WHERE email = ?";
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      connection = ConnectionFactory.getConnection();
      statement = connection.prepareStatement(admQuery);
      statement.setString(1, emailLogin);
      resultSet = statement.executeQuery();
      while (resultSet.next()) {
        int id_adm = resultSet.getInt("id_administrador");
        String name = resultSet.getString("nome");
        String email = resultSet.getString("email");
        String password = resultSet.getString("senha");
        int age  = resultSet.getInt("idade");
        User administrador = new Admin(id_adm, name, password, age, email);
        loggedUser.add(administrador);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (statement != null) {
          statement.close();
        }

        if(resultSet != null) {
          resultSet.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return loggedUser;
  }


  @Override
  public boolean saveUser(User admin) {
    final String questionQuery = "INSERT INTO administrador (nome, email, senha, idade) VALUES (?, ?, ?, ?)";
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    try {
      connection = ConnectionFactory.getConnection();
      statement = connection.prepareStatement(questionQuery);
      statement.setString(1, admin.getName());
      statement.setString(2, admin.getEmail());
      statement.setString(3, admin.getPassword());
      statement.setInt(4, admin.getAge());

      statement.execute();


    }catch (Exception e) {
      e.printStackTrace();
      return false;
    } finally {
      try{
        if (statement != null) {
          statement.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return true;
  }

  @Override
  public void deleteUser(int id) {
  }

  @Override
  public void updateUser(User updateAdmin) {

  }

}