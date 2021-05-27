package com.brunomilitzer.clinicals.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Patient extends AbstractEntity {

    private static final long serialVersionUID = -2348699268542588161L;

    private String lastName;

    private String firstName;

    private Integer age;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "patient")
    private List<ClinicalData> clinicalData;

    @Override
    public Long getId() {

        return super.getId();
    }

    @Override
    public void setId(final Long id) {

        super.setId(id);
    }

    public String getLastName() {

        return this.lastName;
    }

    public void setLastName(final String lastName) {

        this.lastName = lastName;
    }

    public String getFirstName() {

        return this.firstName;
    }

    public void setFirstName(final String firstName) {

        this.firstName = firstName;
    }

    public Integer getAge() {

        return this.age;
    }

    public void setAge(final Integer age) {

        this.age = age;
    }

    public List<ClinicalData> getClinicalData() {

        return this.clinicalData;
    }

    public void setClinicalData(final List<ClinicalData> clinicalData) {

        this.clinicalData = clinicalData;
    }

    @Override
    public String toString() {

        return "Patient{" +
                "id=" + super.getId() +
                ", lastName='" + this.lastName + '\'' +
                ", firstName='" + this.firstName + '\'' +
                ", age=" + this.age +
                '}';
    }

}
