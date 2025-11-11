package com.practicehibernate;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Worker {
    @Id
    private int id;
    private String name;
    private String tech;
    /*
        This if when doing One To One
        @OneToOne
        private Laptop laptop;
        When doing One To Many and Many To One, the One To Many annotation will create a separate combined table with only keys

        To prevent this and have the Many to one table have it's id and this worker id as a foreign key, you would used
        mappedBy in the annotation

        @OneToMay(mappedBy = "workerId")
        And this will tell hiberante to let the workerId section in Laptop class handle the mapping

        For Many to Many relationship, use:
        @ManyToMany


        -- Notes --
        By default hibernate uses Lazy fetch and level 1 cache for each session
        So if you get information during the session using find or another operation, level 1 cache will store that
        data for that session

        Also lazy fetch is done as well for Entities with associated relationships. For example, with the one to many
        relationship with laptops, if the user did find on Worker and the specified id, the user would only retrieve
        the data from the worker table.

        But if the user tried to print the worker during the same session, it would lazy fetch the rest of the data
        so the user could see worker and the laptops listed

        you can change this by saying
        @OneToMany(fetch=FetchType.EAGER)
        This will fetch it all at once instead of waiting

        It is set to this by default
        @OneToMany(fetch = FetchType.LAZY)

     */

    @OneToMany
    private List<Laptop> laptops;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tech='" + tech + '\'' +
                ", laptops=" + laptops +
                '}';
    }
}
