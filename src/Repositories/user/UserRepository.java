package Repositories.user;

import Entities.user.User;
import Util.Utils;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {

    private static final List<User> playerList = new ArrayList<User>();
    private static final List<User> adminList = new ArrayList<User>();

    @Override
    public List<User> getPlayers() {
        return playerList;
    }

    @Override
    public List<User> getAdmins() {
        return adminList;
    }

    public void saveUser(User user) {

        if (!Utils.isPlayer(user)) {
            try {
                adminList.add(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            playerList.add(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deletePlayer(int id) {
        for (User player : playerList) {
            if (player.getId() == id) {
                try {
                    playerList.remove(player);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void deleteAdmin(int id) {
        for (User admin : adminList) {
            if (admin.getId() == id) {
                try {
                    adminList.remove(admin);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void updateUser(User user) {
    }
}
