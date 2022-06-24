package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    private static final Connection connection = Util.getInstance().getConnection();

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {

        String sqlQuery = "CREATE TABLE Users ("
                + "id INT(64) NOT NULL AUTO_INCREMENT,"
                + "name VARCHAR(255),"
                + "lastName VARCHAR(255),"
                + "age INT(64), "
                + "PRIMARY KEY(id))";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sqlQuery);
            System.out.println("Table Created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {

        String sqlQuery = "DROP TABLE IF EXISTS Users";

        try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.executeUpdate();
            System.out.println("Table Dropped");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {

        String sqlQuery = "INSERT INTO Users " +
                "(name, lastName, age) " +
                "VALUES(" +
                name + ", " +
                lastName + ", " +
                age + ")";

        try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {

        String sqlQuery = "DELETE FROM ADDRESS WHERE ID=" + id;

        try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {

        List<User> usersList = new ArrayList<>();
        String sqlQuery = "SELECT * FROM Users";


        try (ResultSet resultSet = connection.createStatement().executeQuery(sqlQuery)) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));

                usersList.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usersList;
    }

    public void cleanUsersTable() {

        String sqlQuery = "TRUNCATE TABLE Users";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}