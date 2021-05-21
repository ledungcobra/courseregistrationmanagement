package com.ledungcobra.entites;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "TEACHING_MANAGER")
@Getter
@Setter
public class TeachingManager extends User {

    @Id
    @Column(name = "TEACHING_MANAGER_ID")
    private String id;

    public TeachingManager(String fullName,String id) {
        super(fullName, id);
        this.id = id;
    }

    public TeachingManager() {

    }

    @Override
    public String getUserName() {
        return this.id;
    }

    @Override
    public void create(){
        super.create();
        this.password = this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TeachingManager that = (TeachingManager) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }
}
