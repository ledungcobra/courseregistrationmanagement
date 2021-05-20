package com.ledungcobra.entites.embedable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

import static com.ledungcobra.utils.Constants.SEMESTER_CHECK_CONSTRAINT_SEMESTER_NAME;

@Embeddable
@Getter
@Setter
public class SemesterId implements Serializable {

    @Column(name = "SEMESTER_NAME", columnDefinition = "VARCHAR(255) CHARSET utf8 " + SEMESTER_CHECK_CONSTRAINT_SEMESTER_NAME)
    private String semesterName;
    @Column(name = "YEAR")
    private Integer year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SemesterId that = (SemesterId) o;
        return Objects.equals(semesterName, that.semesterName) && Objects.equals(year, that.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(semesterName, year);
    }
}
