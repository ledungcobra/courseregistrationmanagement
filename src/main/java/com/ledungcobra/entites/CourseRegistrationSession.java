package com.ledungcobra.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "COURSE_REGISTRATION_SESSION")
@Getter
@Setter
public class CourseRegistrationSession extends BaseEntity {

    @Id
    @Column(name = "CSR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "START_DATE", nullable = false)
    private Date startDate;

    @Column(name = "END_DATE", nullable = false)
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "SEMESTER_ID",
            foreignKey = @ForeignKey(name = "FK_COURSE_REGISTRATION_SESSION_SEMESTER"))
    private Semester semester;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CourseRegistrationSession that = (CourseRegistrationSession) o;
        return Objects.equals(id, that.id) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(semester, that.semester);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, startDate, endDate, semester);
    }
}
