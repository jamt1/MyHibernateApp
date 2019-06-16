package model;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "whom")
    private String whom;

    @Column(name = "whom_from")
    private String whom_from;

    @Column(name = "status")
    private String status;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getWhom() {
        return whom;
    }
    public void setWhom(String whom) {
        this.whom = whom;
    }

    public String getWhom_from() {
        return whom_from;
    }
    public void setWhom_from(String whom_from) {
        this.whom_from = whom_from;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

}
