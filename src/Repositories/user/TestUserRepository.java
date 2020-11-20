package Repositories.user;

import Entities.user.Admin;
import Entities.user.Player;
import Entities.user.User;

import java.util.List;

public class TestUserRepository {

  public static void main(String[] args) {

    //! instanciando os usuários:
    User admin1 = new Admin(1, "Edson", "edson123", 13, "edson@hotmail.com");
    User admin2 = new Admin(2, "Jorge", "jorge123", 12, "jorge@hotmail.com");
    User admin3 = new Admin(3, "Luan", "luan123", 11, "luan@hotmail.com");
    User player1 = new Player(1, "Edson", "edson123", 13, "2 serie", true);
    User player2 = new Player(2, "Felipe", "felipe123", 13, "3 serie", false);
    User player3 = new Player(3, "Bruno", "burno123", 13, "3 serie", false);

    //! instanciando o repositorio de usuários:
    UserRepository playerRepo = new PlayerRepository();
    UserRepository adminRepo = new AdminRepository();

    //! adicionando os usuários aos seus repositorios:

    adminRepo.saveUser(admin1);
    adminRepo.saveUser(admin2);
    adminRepo.saveUser(admin3);
    playerRepo.saveUser(player1);
    playerRepo.saveUser(player2);
    playerRepo.saveUser(player3);

    //! pegando todos os usuarios do repositorio:
    List<User> players;
    players = playerRepo.getUsers();

    List<User> admins;
    admins = adminRepo.getUsers();

    //! getUser TEST
    for(User playerList : players) {
      System.out.printf("Nome do jogador %s", playerList.getName());
      System.out.println();
    }

    for(User adminList : admins) {
      System.out.printf("Nome do admin %s", adminList.getName());
      System.out.println();
    }

    //! delete user TEST
    adminRepo.deleteUser(1);

    List<User> newAdminList;
    newAdminList = adminRepo.getUsers();

    for(User adminList : newAdminList) {
      System.out.printf("Nome do admin %s",  adminList.getName());
      System.out.println();
    }
  }
}
