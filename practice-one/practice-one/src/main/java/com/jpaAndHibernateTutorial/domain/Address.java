package com.jpaAndHibernateTutorial.domain;

import javax.persistence.*;

@Entity
@Table
public class Address {
    public static final String TABLE_NAME = "address";
    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String address;
    @ManyToOne
    @JoinColumn(name = "c_id")
    private City city;

    public Address() {
    }

    // Whit use of annotation (@JoinColumn) in entity Address and field addressList in entity City can build a middle table
    /* This code is for entity City :
    @OneToMany
    private List<Address> addressList;*/

    /*@ManyToOne
    @JoinColumn(name = "c_id")
    private City city;*/
    // Whit use of annotation (@JoinColumn) in entity Address and field addressList in entity City can build a middle table

    // To establish a two-way relationship between two entities, we use (@ManyToOne Or ...) annotation for each of them.
    // Many Address To One City
    // Annotation (@ManyToOne) does not have mappedBy
    /*@ManyToOne
    private City city;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
