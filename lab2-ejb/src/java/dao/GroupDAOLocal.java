package dao;

import java.util.List;
import javax.ejb.Local;
import models.StudentGroup;

@Local
public interface GroupDAOLocal {
    List<StudentGroup> getAllGroups();
    StudentGroup getGroupById(int id);
    void createGroup(StudentGroup group);
    StudentGroup updateGroup(StudentGroup group);
    void deleteGroup(StudentGroup group);
}
