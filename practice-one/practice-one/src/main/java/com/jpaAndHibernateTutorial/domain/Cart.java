package com.jpaAndHibernateTutorial.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Cart {
    @Id
    @GeneratedValue
    private Long id;

    private Long userId;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Product> productList = new ArrayList<>();

    @OneToMany
    private Set<User> users = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userId=" + userId +
                ", productList=" + productList +
                ", users=" + users +
                '}';
    }
}
