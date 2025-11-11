package com.practicehibernate;

import jakarta.persistence.*;

/*

   @Table
   When done like this, the table would have the specific name
   @Column will allow you to specify column name
   @Transient will skip this value when creating the table
   so you can do operation with the value in the object but not have it
   in the table
 */
@Entity()
@Table(name="employees_table")
public class Employee {
    @Id
    private int aid;
    @Column(name="alien_name")
    private String name;

    @Transient
    private String tech;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
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

    @Override
    public String toString() {
        return "Employee{" +
                "aid=" + aid +
                ", name='" + name + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
}
