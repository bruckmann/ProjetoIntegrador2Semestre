package Repositories;

import Entities.Admin;
import Entities.Player;
import Entities.User;
import Util.Utils;

import java.util.ArrayList;
import java.util.List;

public class TestUserRepository {

    public static void main(String[] args) {

        User player1 = new Player(1,
                "Felipe Bruckmann",
                "Player",
                "felipe123",
                19,
                "felipebruckmann@hotmail.com",
                "Terceiro ano",
                false);

        User admin1 = new Admin(1,
                "Felipe Bruckmann",
                "admin",
                "felipe123",
                19,
                "felipebruckmann@hotmail.com");

        UserRepository repo = new UserRepository();


        //! saveUser TEST:
        System.out.println(repo.saveUser(admin1));
        System.out.println(repo.saveUser(player1));
        System.out.println(repo.saveUser(player1));
        System.out.println(repo.saveUser(player1));


        List<User> players = new ArrayList<User>();
        players = repo.getPlayers();

        //! getUser TEST:
        for(User player : players) {
            System.out.printf("Nome do jogador %s", player.getName());
            System.out.println();
        }

    }
}
