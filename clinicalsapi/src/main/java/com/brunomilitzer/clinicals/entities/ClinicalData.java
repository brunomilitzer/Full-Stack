package com.brunomilitzer.clinicals.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "clinicaldata")
public class ClinicalData extends AbstractEntity {

    private static final long serialVersionUID = 7749637122571149008L;

    private String componentName;

    private String componentValue;

    private Timestamp measuredDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    @JsonIgnore
    private Patient patient;

    @Override
    public Long getId() {

        return super.getId();
    }

    @Override
    public void setId(final Long id) {

        super.setId(id);
    }

    public String getComponentName() {

        return this.componentName;
    }

    public void setComponentName(final String componentName) {

        this.componentName = componentName;
    }

    public String getComponentValue() {

        return this.componentValue;
    }

    public void setComponentValue(final String componentValue) {

        this.componentValue = componentValue;
    }

    public Timestamp getMeasuredDateTime() {

        return this.measuredDateTime;
    }

    public void setMeasuredDateTime(final Timestamp measuredDateTime) {

        this.measuredDateTime = measuredDateTime;
    }

    public Patient getPatient() {

        return this.patient;
    }

    public void setPatient(final Patient patient) {

        this.patient = patient;
    }

    @Override
    public String toString() {

        return "ClinicalData{" +
                "id=" + super.getId() +
                ", componentName='" + this.componentName + '\'' +
                ", componentValue='" + this.componentValue + '\'' +
                ", measuredDateTime=" + this.measuredDateTime +
                '}';
    }

}
