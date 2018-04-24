package fr.eservices.drive.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Category  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer orderIdx;

    public Category() {
    }

    public Category(Integer id, String name, Integer orderIdx) {
        this.id = id;
        this.name = name;
        this.orderIdx = orderIdx;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrderIdx() {
        return orderIdx;
    }

    public void setOrderIdx(Integer orderIdx) {
        this.orderIdx = orderIdx;
    }
}
