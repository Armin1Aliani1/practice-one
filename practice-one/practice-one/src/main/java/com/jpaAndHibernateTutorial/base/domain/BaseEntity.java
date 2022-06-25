package com.jpaAndHibernateTutorial.base.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

// @MappedSuperclass : Each class that inherits the BaseEntity class implements or maps the fields in that class in the database.
@MappedSuperclass
public abstract class BaseEntity<ID extends Serializable> implements Serializable {
    // Serializable : Marker transition
    @Id
    @GeneratedValue
    private ID id;

    public BaseEntity() {
    }

    public BaseEntity(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }
}
