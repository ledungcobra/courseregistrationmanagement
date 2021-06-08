package com.ledungcobra.entites;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "COURSE_REGISTRATION_SESSION")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class CourseRegistrationSession extends BaseEntity
{

    @Id
    @Column(name = "CSR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "START_DATE", nullable = false)
    private Date startDate;

    @Column(name = "END_DATE", nullable = false)
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "SEMESTER_ID",
            foreignKey = @ForeignKey(name = "FK_COURSE_REGISTRATION_SESSION_SEMESTER"))
    private Semester semester;

    public CourseRegistrationSession(Date startDate, Date endDate)
    {
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
