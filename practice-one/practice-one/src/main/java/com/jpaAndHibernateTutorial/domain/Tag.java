package com.jpaAndHibernateTutorial.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = Tag.TABLE_NAME)
public class Tag {

    public static final String TABLE_NAME = "tag";
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    // @JoinTable : The following commands can be used to rename the table and to rename the columns
    @ManyToMany
    @JoinTable(
            name = "tag_user_join_table",
            joinColumns = @JoinColumn(name = "my_t_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "my_u_id")
    )
    private Set<User> users = new HashSet<>();

    public Tag() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
