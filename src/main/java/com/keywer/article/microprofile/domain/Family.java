package com.keywer.article.microprofile.domain;


import com.keywer.article.microprofile.domain.enums.WaterType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Family implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private long id;
    @NotBlank
    private String name;
    @NotNull
    @Column(name="WATER_TYPE")
    private WaterType waterType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="family")
    private Collection<Fish> fishs;

    public Family() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WaterType getWaterType() {
        return waterType;
    }

    public void setWaterType(WaterType waterType) {
        this.waterType = waterType;
    }

    public Collection<Fish> getFishs() {
        return fishs;
    }

    public void setFishs(Collection<Fish> fishs) {
        this.fishs = fishs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return id == family.id &&
                Objects.equals(name, family.name) &&
                waterType == family.waterType &&
                Objects.equals(fishs, family.fishs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, waterType, fishs);
    }

    @Override
    public String toString() {
        return "Family{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", waterType=" + waterType +
                ", fishs=" + fishs +
                '}';
    }
}


