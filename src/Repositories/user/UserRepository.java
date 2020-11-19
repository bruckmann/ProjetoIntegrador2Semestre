package Repositories.user;

import Entities.user.User;
import Util.Utils;

import java.util.ArrayList;
import java.util.List;

public abstract class UserRepository implements IUserRepository {

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public abstract User getUserById(int id);

    @Override
    public abstract void saveUser(User user);

    @Override
    public abstract void deleteUser(int id);

    @Override
    public abstract void updateUser(User user);

}