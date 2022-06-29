package com.jpaAndHibernateTutorial.domain;

import com.jpaAndHibernateTutorial.base.domain.BaseEntity;

import javax.persistence.Entity;

//@MappedSuperclass
@Entity
public abstract class Product extends BaseEntity<Long> {
    private Long price;

    public Product() {
    }

    public Product(Long id, Long price) {
        super(id);
        this.price = price;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + getId() + "," +
                "price=" + price +
                '}';
    }
}
