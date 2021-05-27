package com.brunomilitzer.flightreservation.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class User extends AbstractEntity {

    private static final long serialVersionUID = 7962713276350033652L;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public String getFirstName() {

        return this.firstName;
    }

    public void setFirstName(final String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return this.lastName;
    }

    public void setLastName(final String lastName) {

        this.lastName = lastName;
    }

    public String getEmail() {

        return this.email;
    }

    public void setEmail(final String email) {

        this.email = email;
    }

    public String getPassword() {

        return this.password;
    }

    public void setPassword(final String password) {

        this.password = password;
    }

    public Set<Role> getRoles() {

        return this.roles;
    }

    public void setRoles(final Set<Role> roles) {

        this.roles = roles;
    }

    @Override
    public String toString() {

        return "User{" +
                "firstName='" + this.firstName + '\'' +
                ", lastName='" + this.lastName + '\'' +
                ", email='" + this.email + '\'' +
                ", password='" + this.password + '\'' +
                '}';
    }

}
