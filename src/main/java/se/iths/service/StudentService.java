package se.iths.service;

import se.iths.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;

    public Student createStudent(Student student){
        entityManager.persist(student);
        return student;
    }

    //JOBBA PÅ DENNA, HÄMTA {lastName}????
    public List<Student> getAllStudents(){
        return entityManager.createQuery("SELECT i from Student i", Student.class).getResultList();
    }

    public List<Student> getStudentByLastname(String lastname){
        return entityManager.createQuery(
                "SELECT i from Student i WHERE i.lastname LIKE :studentName")
                .setParameter("studentName", lastname)
                .getResultList();
    }

    public Student updateStudent(Student student){
        entityManager.merge(student);
        return student;
    }

    public Student updateStudentLastName(Long id, String lastname){
        Student foundStudent = entityManager.find(Student.class, id);
        foundStudent.setLastname(lastname);
        return entityManager.merge(foundStudent);
    }

    public void deleteStudent(Long id){
        Student foundStudent = entityManager.find(Student.class, id);
        entityManager.remove(foundStudent);
    }
}
