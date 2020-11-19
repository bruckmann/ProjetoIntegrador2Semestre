package Repositories.user;

import Entities.user.User;

import java.util.List;

public interface IUserRepository {

    List<User>getUsers();
    User getUserById(int id);
    void saveUser(User user);
    void deleteUser(int id);
    void updateUser(User user);

}
