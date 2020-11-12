package Repositories;

import java.util.List;
import Entities.User;

public interface IUserRepository {

    public List<User> getAdmins();
    public List<User>getPlayers();
    public String saveUser(User user);
    public boolean deleteUser(int id);
    public boolean updateUser(User user);

}
