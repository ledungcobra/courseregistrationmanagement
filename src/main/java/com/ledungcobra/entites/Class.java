package com.ledungcobra.entites;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Class")
@Getter
@Setter
public class Class extends BaseEntity{

    @Id
    @Column(name = "CLASS_ID")
    private Long id;

    @Column(name = "CLASS_NAME",unique = true)
    private String className;

    @ManyToOne
    @JoinColumn(name = "CREATED_BY", foreignKey = @ForeignKey(name = "FK_CLASS_TEACHING_MANAGER"))
    private TeachingManager createdBy;

    @OneToMany(mappedBy = "studiedClass",fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    private List<StudentAccount> students;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Class aClass = (Class) o;
        return Objects.equals(id, aClass.id) && Objects.equals(className, aClass.className) && Objects.equals(createdBy, aClass.createdBy) && Objects.equals(students, aClass.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, className, createdBy, students);
    }
}
