package com.jpaAndHibernateTutorial.base.repository;

import com.jpaAndHibernateTutorial.base.domain.BaseEntity;

import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

public interface BaseRepository<E extends BaseEntity<ID>, ID extends Serializable> {

    E save(E e);

    E findById(Id id);

    List<E> findAll();

    void deleteById(ID id);

    long countAll();

    void beginTransaction();

    void commitTransaction();

    void rollbackTransaction();

    EntityTransaction getTransaction();

}
