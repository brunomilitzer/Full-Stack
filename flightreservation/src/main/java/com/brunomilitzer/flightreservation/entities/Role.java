package com.brunomilitzer.flightreservation.entities;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Role extends AbstractEntity implements GrantedAuthority {

    private static final long serialVersionUID = -4730983631985819899L;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public String getName() {

        return this.name;
    }

    public void setName(final String name) {

        this.name = name;
    }

    public Set<User> getUsers() {

        return this.users;
    }

    public void setUsers(final Set<User> users) {

        this.users = users;
    }

    @Override
    public String getAuthority() {

        return this.name;
    }

    @Override
    public String toString() {

        return "Role{" +
                "name='" + this.name + '\'' +
                ", users=" + this.users +
                '}';
    }

}
