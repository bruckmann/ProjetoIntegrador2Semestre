package Repositories.user;

import Entities.user.User;

import java.util.List;

public interface IUserRepository {

    public List<User> getAdmins();
    public List<User>getPlayers();
    public void saveUser(User user);
    public void deletePlayer(int id);
    public void deleteAdmin(int id);
    public void updateUser(User user);

}
