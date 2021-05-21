package com.ledungcobra.entites;

import com.ledungcobra.dao.CourseDao;
import com.ledungcobra.entites.embedable.CourseSemesterId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "COURSE_SEMESTER")
@Getter
@Setter
public class CourseSemester extends BaseEntity {
    @EmbeddedId
    private CourseSemesterId courseSemesterId;

    @ManyToMany(mappedBy = "courseSemesters")
    private List<StudentAccount> studentAccounts;


    public Course getCourse(){
        return this.courseSemesterId.getCourse();
    }

    public Semester getSemester(){
        return this.courseSemesterId.getSemester();
    }

}
