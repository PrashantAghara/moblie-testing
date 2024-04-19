package dao;

import database.UserDB;
import exception.UserAlreadyExistsException;
import model.User;

public class UserDAO {
    private final UserDB userDB;

    public UserDAO() {
        this.userDB = new UserDB();
    }

    public void createUser(User user) {
        if (this.getUserById(user.getId()) != null) {
            throw new UserAlreadyExistsException("User with id : " + user.getId() + " already exists");
        }
        this.userDB.createUser(user);
    }

    public User getUserById(String id) {
        return this.userDB.getUserById(id);
    }
}
