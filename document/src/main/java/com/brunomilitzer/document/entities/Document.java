package com.brunomilitzer.document.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.io.Serializable;

@Entity
public class Document implements Serializable {

    private static final long serialVersionUID = 6217107592499631041L;

    @Id
    private Long id;

    private String name;

    @Lob
    private byte[] data;

    public Long getId() {

        return this.id;
    }

    public void setId(final Long id) {

        this.id = id;
    }

    public String getName() {

        return this.name;
    }

    public void setName(final String name) {

        this.name = name;
    }

    public byte[] getData() {

        return this.data;
    }

    public void setData(final byte[] data) {

        this.data = data;
    }

}
