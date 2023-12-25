package dev.repository;
import dev.controller.StudentController;
import dev.domain.Student;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private DataSource dataSource;

    public StudentRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void create(Student student) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO studenttb (name, email, dateOfBirth, gender, quota, country) VALUES (?, ?, ?, ?, ?, ?)");
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getEmail());
        preparedStatement.setDate(3, Date.valueOf(student.getDateOfBirth()));
        preparedStatement.setString(4, student.getGender().toString());
        preparedStatement.setString(5, student.getQuota());
        preparedStatement.setString(6, student.getCountry());
        preparedStatement.execute();
    }

    public void update(Student student) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE studenttb set name = ?, email = ?, dateOfBirth = ?, gender = ?, quota = ?, country = ? WHERE Id = ?");
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getEmail());
        preparedStatement.setDate(3, Date.valueOf(student.getDateOfBirth()));
        preparedStatement.setString(4, student.getGender().toString());
        preparedStatement.setString(5, student.getQuota());
        preparedStatement.setString(6, student.getCountry());
        preparedStatement.setInt(7, student.getId());
        preparedStatement.execute();
    }

    public Student get(int id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT Id, name, email, dateOfBirth, gender, quota, country FROM studenttb WHERE Id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return new Student(
                    resultSet.getInt("Id"),
                    resultSet.getString("name"),
                    resultSet.getString("email"),
                    resultSet.getDate("dateOfBirth").toLocalDate(),
                    StudentController.ConvertToGender(resultSet.getString("gender")),
                    resultSet.getString("quota"),
                    resultSet.getString("country")
            );
        } else {
            return null;
        }
    }

    public List<Student> getAll() throws SQLException {
        List<Student> students = new ArrayList<>();
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT Id, name, email, dateOfBirth, gender, quota, country FROM studenttb");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            students.add(new Student(resultSet.getInt("Id"), resultSet.getString("name"), resultSet.getString("email"), resultSet.getDate("dateOfBirth").toLocalDate(), StudentController.ConvertToGender(resultSet.getString("gender")), resultSet.getString("quota"), resultSet.getString("country")));
        }
        return students;
    }
    public boolean Delete(int Id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from studenttb where Id = ?");
        preparedStatement.setInt(1, Id);
        return preparedStatement.executeUpdate() > 0; //affectedRows
    }
}
