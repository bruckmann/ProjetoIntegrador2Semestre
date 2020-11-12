package Repositories;

import Entities.User;
import Util.Utils;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {

    private List<User> playerList = new ArrayList<User>();
    private List<User> adminList = new ArrayList<User>();

    @Override
    public List<User> getPlayers() {
        return this.playerList;
    }

    @Override
    public List<User> getAdmins() {
        return this.adminList;
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
        for (User player : this.playerList) {
            if (player.getId() == id) {
                try {
                    this.playerList.remove(player);
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
        for (User admin : this.adminList) {
            if (admin.getId() == id) {
                try {
                    this.adminList.remove(admin);
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
