package be.isib.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("ALL")
@Entity
@Table(name="LANGUE")
public class Langue {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String langue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    @Override
    public String toString() {
        return langue;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null) return false;
        return ((Langue) obj).getId().equals(this.getId());
    }
}
