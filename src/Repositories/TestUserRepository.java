package Repositories;

import Entities.Admin;
import Entities.Player;
import Entities.User;
import java.util.List;

public class TestUserRepository {

    public static void main(String[] args) {


        User admin = new Admin(1, "Edson", "edson123", 13, "edson@hotmail.com");
        User player = new Player(1, "Edson", "edson123", 13, "2 serie", true);

        UserRepository repo = new UserRepository();


        //! saveUser TEST:
        System.out.println(repo.saveUser(admin));
        System.out.println(repo.saveUser(player));


        List<User> players;
        players = repo.getPlayers();

        //! getUser TEST:
        for(User playerList : players) {
            System.out.printf("Nome do jogador %s", playerList.getName());
            System.out.println();
        }

    }
}
