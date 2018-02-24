package ru.eshop.model;

import javax.persistence.*;

@Entity
@Table(name = "ROLE")
@NamedQueries(
        @NamedQuery(name = "findRoleByName",query = "from Role r where r.name=:name")
)
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    public Role() {
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
