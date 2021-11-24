package se.iths.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subject_id;

    @NotEmpty
    @NotNull
    private String subjectname;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

    @ManyToOne
    private Teacher teacher;


    public Subject(String subjectname) {
        this.subjectname = subjectname;
    }

    public Subject(){
    }

    public Long getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(Long subject_id) {
        this.subject_id = subject_id;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

}
