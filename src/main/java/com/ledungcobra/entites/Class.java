package com.ledungcobra.entites;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Class")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class Class extends BaseEntity
{

    @Id
    @Column(name = "CLASS_ID")
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CLASS_NAME", unique = true)
    private String className;

    @ManyToOne
    @JoinColumn(name = "CREATED_BY", foreignKey = @ForeignKey(name = "FK_CLASS_TEACHING_MANAGER"))
    private TeachingManager createdBy;

    @OneToMany(mappedBy = "studiedClass", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST})
    private List<StudentAccount> students;


    @Override
    public String toString()
    {
        return this.className;
    }
}
