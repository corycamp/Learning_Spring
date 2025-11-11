package com.practicehibernate;


import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

/*
    @Embeddable
    Allows you to add all the class columns to the table that is using Laptop
 */

@Entity
//Enable L2 caching
@Cacheable
public class Laptop {
    @Id
    private int lid;
    private String brand;
    private String model;
    private int ram;
    /*
        If I am doing a One To Many (1 worker has multiple laptops)
        This table would have Many to One relation ship (Many laptops to 1 worker)
        So to have the workerId on this table a foreign key, I would need to add a workerId variable
        and annotate it

        @ManyToOne
        private int workerId;

        For Many to Many relationship and allowing to control the mapping use
         @ManyToMany(mappedBy = "laptops")
         laptops is the field in the Worker class, so it knows to let that class handle the mapping
     */

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "lid=" + lid +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", ram=" + ram +
                '}';
    }
}
