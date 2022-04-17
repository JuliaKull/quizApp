package ee.kull.configuration;

import ee.kull.model.User;

import java.sql.*;

public class DataBaseHandler extends Configuration {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException { //Подключение к БД
        String connectionString = "jdbc:postgresql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("org.postgresql.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }

    public void signUpUser(User user) {  //Заносим в БД
        String insert = "INSERT INTO quiz ( username,password) VALUES(?,?)";

        PreparedStatement prST = null;
        try {
            prST = getDbConnection().prepareStatement(insert);
            prST.setString(1, user.getUsername());
            prST.setString(2, user.getPassword());
            prST.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public ResultSet getUser(User user) { //получить данные из ДБ
        ResultSet resSet = null;
        String select = "SELECT * FROM quiz WHERE username=? AND password=?;";


        try {
            PreparedStatement prST = getDbConnection().prepareStatement(select);
            prST.setString(1, user.getUsername());
            prST.setString(2, user.getPassword());
            resSet = prST.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
        return resSet;
    }

    public void levelSelection(String level) {  //Заносим в БД уровень теста

        String update = " UPDATE quiz SET level = " + level + " WHERE id IN (SELECT max(id) FROM quiz);";

        PreparedStatement prST = null;
        try {
            prST = getDbConnection().prepareStatement(update);
            prST.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addPoints() {  //Заносим в БД правельный ответ

        String update = "UPDATE quiz SET result = COALESCE(result, 0) + 1 WHERE id IN (SELECT max(id) FROM quiz);";

        PreparedStatement prST = null;
        try {
            prST = getDbConnection().prepareStatement(update);
            prST.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getScore() { //получить данные из ДБ
        ResultSet resSet = null;
        String select = "SELECT result FROM quiz WHERE id IN (SELECT max(id) FROM quiz);";

        try {
            PreparedStatement prST = getDbConnection().prepareStatement(select);
            resSet = prST.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
        return resSet;
    }
}

