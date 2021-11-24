package se.iths.service;


import se.iths.entity.Student;
import se.iths.entity.Subject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SubjectService {

    @PersistenceContext
    EntityManager entityManager;

    public Subject createSubject(Subject subject){
        entityManager.persist(subject);
        return subject;
    }

    public List<Subject> getAllSubjects(){
        return entityManager.createQuery("SELECT i from Subject i", Subject.class).getResultList();
    }

    public List<Subject> getSubjectBySubjectName(String subjectname){
        return entityManager.createQuery(
                        "SELECT i from Subject i WHERE i.subjectname LIKE :subjectName")
                .setParameter("subjectName", subjectname)
                .getResultList();
    }
}
