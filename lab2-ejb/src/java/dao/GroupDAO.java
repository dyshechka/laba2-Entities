package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import models.StudentGroup;

@Stateless
public class GroupDAO implements GroupDAOLocal {

    @PersistenceContext(unitName = "lab2-ejbPU")
    private EntityManager em;

    @Override
    public List<StudentGroup> getAllGroups() {
        Query query = em.createQuery("SELECT g FROM StudentGroup g");
        return query.getResultList();
    }

    @Override
    public StudentGroup getGroupById(int id) {
        return em.find(StudentGroup.class, id);
    }

    @Override
    public void createGroup(StudentGroup group) {
        em.persist(group);
    }

    @Override
    public StudentGroup updateGroup(StudentGroup group) {
        return em.merge(group);
    }

    @Override
    public void deleteGroup(StudentGroup group) {
        em.remove(em.merge(group));
    }
}
