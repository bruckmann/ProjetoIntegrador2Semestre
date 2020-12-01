package Repositories.user;

import Entities.user.User;

import java.util.List;

public interface IUserRepository {

    List<User>getUsers();
    boolean saveUser(User user);
    boolean deleteUser(int id);
    boolean updateUser(User user);

}
