package com.ledungcobra.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import static com.ledungcobra.utils.Constants.SEMESTER_CHECK_CONSTRAINT_SEMESTER_NAME;

@Entity
@Table(name = "Semester",
        uniqueConstraints = @UniqueConstraint(columnNames = {
                "SEMESTER_NAME",
                "YEAR"
        })
)
@Getter
@Setter
public class Semester extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEMESTER_ID")
    private Long id;


    @Column(name = "SEMESTER_NAME",
            columnDefinition = "VARCHAR(255) CHARSET utf8 " + SEMESTER_CHECK_CONSTRAINT_SEMESTER_NAME,
            nullable = false
    )
    private String semesterName;

    @Column(name = "YEAR", nullable = false)
    private Integer year;


    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "ACTIVE")
    private Boolean active;

    @ManyToMany(mappedBy = "semesters", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Course> courses;

    public Semester(String semesterName, Integer year, Date startDate, Date endDate, Boolean active) {
        this.semesterName = semesterName;
        this.year = year;
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = active;
    }

    public Semester() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Semester semester = (Semester) o;
        return Objects.equals(id, semester.id) && Objects.equals(startDate, semester.startDate) && Objects.equals(endDate, semester.endDate) && Objects.equals(active, semester.active) && Objects.equals(courses, semester.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, startDate, endDate, active, courses);
    }
}

