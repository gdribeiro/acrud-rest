package com.example.acrud.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class TourPackage {

    @Id
    private String code;

    @Column
    private String name;

    protected TourPackage() {
    }

    public TourPackage(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return  this.code;
    }

    public String getName() {
        return this.name;
    }


    @Override
    public String toString() {
        return  "TourPackage{" +
                "code'" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourPackage that = (TourPackage) o;
        return Objects.equals(this.code, that.code) &&
                Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() { return Objects.hash(code, name); }
}
