import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationDB {

    public static List<User> getAll() throws SQLException, ClassNotFoundException {
        List<User> users = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        String sql = "SELECT * FROM registredusers";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()) {
            users.add(new User(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)));
        }
        return users;
    }
    public static String authenticate(User u) throws SQLException, ClassNotFoundException {
        String fullname = null;
        Connection connection = ConnectionManager.getConnection();
        String sql = "SELECT FullName FROM registredusers where Email = ? and Password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, u.getEmail());
        preparedStatement.setString(2, u.getPassword());
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            fullname = resultSet.getString(1);
        }
        return fullname;
    }

    public static void create(User u) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionManager.getConnection();
        String sql = "INSERT INTO registredusers SET Email = ?, FullName = ?, Password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, u.getEmail());
        preparedStatement.setString(2, u.getFullName());
        preparedStatement.setString(3, u.getPassword());
        preparedStatement.execute();
    }

    public static void update(User u) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionManager.getConnection();
        String sql = "UPDATE registredusers SET Email = ?, FullName = ?, Password = ? WHERE Email = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, u.getEmail());
        preparedStatement.setString(2, u.getFullName());
        preparedStatement.setString(3, u.getPassword());
        preparedStatement.executeUpdate();
    }

    public static void delete(String email) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionManager.getConnection();
        String sql = "DELETE FROM registredusers WHERE Email = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, email);
        preparedStatement.executeUpdate();
    }
}
