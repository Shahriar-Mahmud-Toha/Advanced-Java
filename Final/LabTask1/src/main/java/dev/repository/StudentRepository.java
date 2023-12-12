package dev.repository;

import dev.domain.Gender;
import dev.domain.Student;
import dev.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;

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

    public Student get(int Id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT Id, name, email, dateOfBirth, gender, quota, country FROM studenttb WHERE Id = ?");
        preparedStatement.setInt(1, Id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            return new Student(resultSet.getInt("Id"), resultSet.getString("name"), resultSet.getString("email"), resultSet.getDate("dateOfBirth").toLocalDate(),resultSet.getString("gender"), resultSet.getString("quota"), resultSet.getString("country"));
        }
        return new Student();
    }
    public Boolean Delete(int Id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from studenttb where Id = ?");
        preparedStatement.setInt(1, Id);
        return preparedStatement.executeUpdate() > 0; //affectedRows
    }
}
