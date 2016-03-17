package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Student;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-17T20:16:03")
@StaticMetamodel(StudentGroup.class)
public class StudentGroup_ { 

    public static volatile SingularAttribute<StudentGroup, String> name;
    public static volatile ListAttribute<StudentGroup, Student> students;
    public static volatile SingularAttribute<StudentGroup, Integer> id;

}