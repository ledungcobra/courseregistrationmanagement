package com.ledungcobra.entites;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "COURSE_INFO", uniqueConstraints = {
        @UniqueConstraint(name = "UK_COURSE_INFO", columnNames = {
                "SUBJECT_ID",
                "SEMESTER_ID"
        })
})
@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class CourseInfo extends BaseEntity
{

    @Id
    @Column(name = "COURSE_INFO_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne
    @JoinColumn(name = "SUBJECT_ID", nullable = false)
    private Subject subject;

    @JoinColumn(name = "SEMESTER_ID", nullable = false)
    @ManyToOne
    private Semester semester;

    public CourseInfo(Subject subject, Semester semester)
    {
        this.subject = subject;
        this.semester = semester;
    }

    @OneToMany(mappedBy = "courseInfo")
    private List<Course> courses;

    @Override
    public String toString()
    {
        return this.subject.getName() + " - " + subject.getCredit() +
                (subject.getCredit() > 1 ? " credits " : " credit ") + this.semester;
    }
}
