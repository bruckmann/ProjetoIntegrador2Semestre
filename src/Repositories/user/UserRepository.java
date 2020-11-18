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

    public String saveUser(User user) {

        if (!Utils.isPlayer(user)) {
            try {
                adminList.add(user);
            } catch (Exception e) {
                return String.format("Não foi possivel cadastrar o %s", user.getName());
            }

            return String.format("Administrador %s cadastrado com sucesso!", user.getName());
        }

        try {
            playerList.add(user);
        } catch (Exception e) {
            return String.format("Não foi possivel cadastrar o %s", user.getName());
        }

        return String.format("Jogadador %s cadastrado com sucesso!", user.getName());
    }

    @Override
    public String deletePlayer(int id) {
        for (User player : playerList) {
            if (player.getId() == id) {
                try {
                    playerList.remove(player);
                    return "Jogador deletado com sucesso!";
                } catch (Exception e) {
                    return "Erro ao deletar jogador";
                }
            }
        }
        return null;
    }

    @Override
    public String deleteAdmin(int id) {
        for (User admin : adminList) {
            if (admin.getId() == id) {
                try {
                    adminList.remove(admin);
                    return "Administrador deletado com sucesso!";
                } catch (Exception e) {
                    return "Erro ao deletar Administrador";
                }
            }
        }
        return null;
    }

    @Override
    public String updateUser(User user) {
        return null;
    }
}
