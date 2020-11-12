package Repositories;

import Entities.Admin;
import Entities.Player;
import Entities.User;
import Util.Utils;
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

        System.out.println(repo.saveUser(admin1));
        System.out.println(repo.saveUser(player1));

    }

}
