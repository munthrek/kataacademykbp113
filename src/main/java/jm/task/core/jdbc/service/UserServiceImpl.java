package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao dao = new UserDaoJDBCImpl();

    public void createUsersTable() throws SQLException {
        dao.createUsersTable();
        System.out.println("Table Created");
    }

    public void dropUsersTable() throws SQLException {
        dao.dropUsersTable();
        System.out.println("Table Dropped");
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        dao.saveUser(name, lastName, age);
        System.out.println("User " + name + " Added");
    }

    public void removeUserById(long id) throws SQLException {
        dao.removeUserById(id);
        System.out.println("User " + id + "Removed");
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users =  dao.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
        return users;
    }

    public void cleanUsersTable() throws SQLException {
        dao.cleanUsersTable();
        System.out.println("Table Cleared");
    }
}