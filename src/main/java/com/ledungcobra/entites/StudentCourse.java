package com.ledungcobra.entites;


import com.ledungcobra.entites.embedable.StudentCourseId;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT_COURSE_SEMESTER")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper = false)
public class StudentCourse extends BaseEntity {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private StudentCourseId studentCourseSemesterId;

    @JoinColumn(name = "SESSION_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private CourseRegistrationSession courseRegistrationSession;

}
