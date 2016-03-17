package dao;

import java.util.List;
import javax.ejb.Local;
import models.Student;

@Local
public interface StudentDAOLocal {
    List<Student> getAllStudents();
    Student getStudentById(int id);
    void createStudent(Student student);
    Student updateStudent(Student student);
    void deleteStudent(Student student);
}
