package by.dobysh.telegram.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table
public class City {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String information;

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

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return Objects.equals(getId(), city.getId()) &&
                Objects.equals(getName(), city.getName()) &&
                Objects.equals(getInformation(), city.getInformation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getInformation());
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", information='" + information + '\'' +
                '}';
    }
}
