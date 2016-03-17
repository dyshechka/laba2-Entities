package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.StudentGroup;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-03-17T20:16:03")
@StaticMetamodel(Student.class)
public class Student_ { 

    public static volatile SingularAttribute<Student, String> name;
    public static volatile SingularAttribute<Student, Date> dateOfBirth;
    public static volatile SingularAttribute<Student, StudentGroup> studentGroup;
    public static volatile SingularAttribute<Student, Integer> id;

}