package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.List;

public class Main {

    private final static UserService userService = new UserServiceImpl();

    public static void main(String[] args) throws SQLException {
        userService.createUsersTable();

        userService.saveUser("Odin", "Pyat", (byte) 78);
        userService.saveUser("Dva", "Shest", (byte) 74);
        userService.saveUser("Tri", "Sem", (byte) 59);
        userService.saveUser("Chetyre", "Vosem", (byte) 74);

        userService.removeUserById(2);

        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user.toString());
        }

        userService.cleanUsersTable();

        userService.dropUsersTable();

        Util.closeConnection();
    }

}
