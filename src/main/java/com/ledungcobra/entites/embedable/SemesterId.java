package com.ledungcobra.entites.embedable;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

import static com.ledungcobra.utils.Constants.SEMESTER_CHECK_CONSTRAINT_SEMESTER_NAME;

@Embeddable
@Getter
@Setter
public class SemesterId implements Serializable {

    @Column(name = "SEMESTER_NAME", columnDefinition = "VARCHAR(255) CHARSET utf8 " + SEMESTER_CHECK_CONSTRAINT_SEMESTER_NAME)
    private String semesterName;
    @Column(name = "YEAR")
    private Integer year;

}
