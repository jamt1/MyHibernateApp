package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class Addressbook implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Addressbook() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    @Column(name = "firstname")
    private String firstname;


}
