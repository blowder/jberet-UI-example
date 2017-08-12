package org.jberet.test.dao.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by sesshoumaru on 8/13/17.
 */
@Entity
public class ProcessingEntity {
    @Id
    @GeneratedValue
    private int id;
    private String key;
    private String value;

    public ProcessingEntity() {
    }

    public ProcessingEntity(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
