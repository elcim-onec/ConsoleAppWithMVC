package com.company.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private Integer id;
    private String name;
    //private List<Score> scores = new ArrayList<>();

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


    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product(String name) {
        this(null, name);
    }

    @Override
    public String toString() {
        return "\n\n Product Id: " + id + "\n"
                + "Name: " + name + "\n";
    }
}
