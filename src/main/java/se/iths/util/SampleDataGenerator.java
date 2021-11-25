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

        teacher1.addSubject(subject1);
        teacher1.addSubject(subject2);
        teacher1.addSubject(subject3);

        teacher2.addSubject(subject4);
        teacher2.addSubject(subject5);

        student1.addSubject(subject1);
        student1.addSubject(subject2);

        student2.addSubject(subject2);
        student2.addSubject(subject3);
        student2.addSubject(subject4);

        student3.addSubject(subject1);
        student3.addSubject(subject2);
        student3.addSubject(subject5);

        entityManager.persist(teacher1);
        entityManager.persist(teacher2);

        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(student3);
    }
}
