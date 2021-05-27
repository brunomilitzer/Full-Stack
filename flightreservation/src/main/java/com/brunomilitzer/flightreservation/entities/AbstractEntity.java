package com.brunomilitzer.flightreservation.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class AbstractEntity implements Serializable {

    private static final long serialVersionUID = -6301380594969792523L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {

        return this.id;
    }

    public void setId(final Long id) {

        this.id = id;
    }

}
