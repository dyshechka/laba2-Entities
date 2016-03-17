package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import models.Student;

@Stateless
public class StudentDAO implements StudentDAOLocal {

    @PersistenceContext(unitName = "lab2-ejbPU")
    private EntityManager em;

    
    @Override
    public List<Student> getAllStudents() {
        Query query = em.createQuery("SELECT s FROM Student s");
        return query.getResultList();
    }

    @Override
    public Student getStudentById(int id) {
        return em.find(Student.class, id);
    }

    @Override
    public void createStudent(Student student) {
        em.persist(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return em.merge(student);
    }

    @Override
    public void deleteStudent(Student student) {
        Student studentDel = em.merge(student);
        em.remove(studentDel);
    }

}
