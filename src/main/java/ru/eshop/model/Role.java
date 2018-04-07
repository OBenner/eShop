package ru.eshop.model;

import javax.persistence.*;

/**
 * The type Role.
 */
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

    /**
     * Instantiates a new Role.
     */
    public Role() {
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }
}
