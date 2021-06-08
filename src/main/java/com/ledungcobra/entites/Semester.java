package com.ledungcobra.entites;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Semester extends BaseEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEMESTER_ID")
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "SEMESTER_NAME",
            columnDefinition = "VARCHAR(255) CHARSET utf8 " + SEMESTER_CHECK_CONSTRAINT_SEMESTER_NAME,
            nullable = false)
    private String semesterName;

    @Column(name = "YEAR", nullable = false)
    private Integer year;


    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "ACTIVE", nullable = false)
    private Boolean active;

    @OneToMany(mappedBy = "semester", cascade = CascadeType.PERSIST)
    private List<CourseInfo> courseInfos;

    public List<CourseInfo> getCourseInfos()
    {
        if (courseInfos == null) courseInfos = new ArrayList<>();
        return courseInfos;
    }

    public Semester(String semesterName, Integer year, Date startDate, Date endDate, Boolean active)
    {
        this.semesterName = semesterName;
        this.year = year;
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = active;
    }

    @Override
    public String toString()
    {
        return this.semesterName + " - " + this.year;
    }
}

