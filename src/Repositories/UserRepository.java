package Repositories;

import Entities.User;

import java.util.List;

public class UserRepository implements IUserRepository {


    @Override
    public List<User> getUser() {
        return null;
    }

    @Override
    public boolean saveUser(User user) {
        return false;
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
