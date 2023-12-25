package dev.service;

import dev.domain.Student;
import dev.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void create(Student student) throws SQLException {
        studentRepository.create(student);
    }

    public void update(Student student) throws  SQLException {
        if(get(student.getId())!=null){
            studentRepository.update(student);
        }
    }

    public Student get(int id) throws SQLException {
        return studentRepository.get(id);
    }
    public boolean delete(int id) throws SQLException {
        return studentRepository.Delete(id);
    }
    public List<Student> getAll() throws SQLException {
        return studentRepository.getAll();
    }

}
