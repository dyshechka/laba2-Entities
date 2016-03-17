package beans;

import dao.GroupDAOLocal;
import dao.StudentDAOLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import models.Student;
import models.StudentGroup;

/**
 *
 * @author Marta
 */
@Named
@SessionScoped
public class Controller implements Serializable {

    @EJB
    private StudentDAOLocal studentDAO;

    @EJB
    private GroupDAOLocal groupDAO;

    private StudentGroup group;
    private Student student;

    public Controller() {
        group = new StudentGroup();
        student = new Student();
    }

    public StudentGroup getGroup() {
        return group;
    }

    public void setGroup(StudentGroup group) {
        this.group = group;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<StudentGroup> getAllGroups() {
        return groupDAO.getAllGroups();
    }

    public String createGroup() {
        group = new StudentGroup();
        return "cg";
    }

    public String createGroupConfirm() {
        groupDAO.createGroup(group);
        group = new StudentGroup();
        return "index";
    }

    public void deleteGroup(int id) {
        groupDAO.deleteGroup(groupDAO.getGroupById(id));
    }

    public String updateGroup(int id) {
        group = groupDAO.getGroupById(id);
        return "ug";
    }

    public String updateGroupConfirm() {
        groupDAO.updateGroup(group);
        group = new StudentGroup();
        return "index";
    }

    public String detailGroup(int id) {
        group = groupDAO.getGroupById(id);
        return "rg";
    }

    public List<Student> getStudentsInGroup() {
        return group.getStudents();
    }

    public String createStudent() {
        group.getStudents().add(student);
        group = groupDAO.updateGroup(group);
        student = new Student();
        return "ok";
    }

    public String updateStudent(int id) {
        student = studentDAO.getStudentById(id);
        return "us";
    }

    public String updateStudentConfirm() {
        if (!group.equals(student.getStudentGroup())) {
            group.getStudents().remove(student);
            student.getStudentGroup().getStudents().add(student);
            groupDAO.updateGroup(student.getStudentGroup());
            group = groupDAO.updateGroup(group);
        }
        studentDAO.updateStudent(student);
        group = groupDAO.getGroupById(group.getId());
        student = new Student();
        return "ok";
    }

    public void deleteStudent(int id) {
        Student s = studentDAO.getStudentById(id);
        group.getStudents().remove(s);
        studentDAO.deleteStudent(s);
        group = groupDAO.updateGroup(group);
    }
}
