package com.brunomilitzer.clinicals.dtos;

public class ClinicalDataRequest {

    private String componentName;

    private String componentValue;

    private Long patientId;

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

    public Long getPatientId() {

        return this.patientId;
    }

    public void setPatientId(final Long patientId) {

        this.patientId = patientId;
    }

    @Override
    public String toString() {

        return "ClinicalDataRequest{" +
                "componentName='" + this.componentName + '\'' +
                ", componentValue='" + this.componentValue + '\'' +
                ", patientId=" + this.patientId +
                '}';
    }

}
