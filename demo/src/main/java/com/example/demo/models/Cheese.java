package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity //tells Spring Boot that you want to store this class into the DB
public class Cheese {
    @Id //It should be a primary key in the DB table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Data layer should generate the primary key value
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @Size(min=1, message = "Description shall be minimum a single character")
    private String description;

    private CheeseType type;

    //We want the data layer to take care of the id
    /*private int cheeseId;
    private static int nextId = 1;*/

    public Cheese(String name, String description) {
        //this(); //call the default constructor
        this.name = name;
        this.description = description;
    }

    public Cheese(){
        /*cheeseId = nextId;
        nextId++;**/
    }

    //id field should only have a getter since it shouldn't be allowed to be changed outside of this class
    public int getId() {
        return id;
    }
/* public int getCheeseId() {
        return cheeseId;
    }

    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Cheese.nextId = nextId;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType type) {
        this.type = type;
    }
}
