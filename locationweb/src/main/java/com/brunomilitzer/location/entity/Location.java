package com.brunomilitzer.location.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Location implements Serializable {

    private static final long serialVersionUID = -2794154158718526189L;

    @Id
    private Long id;

    private String code;

    private String name;

    private String type;

    public Long getId() {

        return this.id;
    }

    public void setId(final Long id) {

        this.id = id;
    }

    public String getCode() {

        return this.code;
    }

    public void setCode(final String code) {

        this.code = code;
    }

    public String getName() {

        return this.name;
    }

    public void setName(final String name) {

        this.name = name;
    }

    public String getType() {

        return this.type;
    }

    public void setType(final String type) {

        this.type = type;
    }

    @Override
    public String toString() {

        return "Location{" +
                "id=" + this.id +
                ", code='" + this.code + '\'' +
                ", name='" + this.name + '\'' +
                ", type='" + this.type + '\'' +
                '}';
    }

}
