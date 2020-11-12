package Repositories;

import Entities.Player;
import Entities.User;
import Util.Utils;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {

    private List<User> playerList = new ArrayList<User>();
    private List<User> adminList = new ArrayList<User>();
    private Object Player;

    @Override
    public List<User> getUser() {
        return null;
    }

    @Override
    public boolean saveUser(User user) {
        if (!Utils.isPlayer(user)) {
            try {
                adminList.add(user);
            } catch (Exception e) {
                return false;
            }

            return true;
        }

        try {
            playerList.add(user);
        } catch (Exception e) {
            return false;
        }

        return true;
    }


    @Override
    public boolean deleteUser(int id) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }
}
