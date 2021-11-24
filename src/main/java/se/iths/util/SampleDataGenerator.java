package se.iths.util;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class SampleDataGenerator {

    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void generateSampleData(){
        Teacher teacher1 = new Teacher("Arvid", "Arvidsson");
        Teacher teacher2 = new Teacher("Gunther", "Gunthersson");

        Student student1 = new Student("Bruno", "Brunosson", "bruno@hotmail.com", "03124");
        Student student2 = new Student("Ciri", "Cirisson", "Ciri@hotmail.com", "03133");
        Student student3 = new Student("Diana", "Dianasson", "Diana@outlook.com", "031383");

        Subject subject1 = new Subject("Math");
        Subject subject2 = new Subject("Geography");
        Subject subject3 = new Subject("Swedish");
        Subject subject4 = new Subject("Java");
        Subject subject5 = new Subject("English");

/*        subject1.addTeacher
        subject2.addTeacher

        subject1.addStudent
        subject2.addStudent
        subject2.addStudent
        subject3.addStudent
        subject4.addStudent
        subject4.addStudent
        subject5.addStudent*/


    }
}
