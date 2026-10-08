package com.build.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * 图形实体
 */
@Getter
@Setter
public class Barchart {
    private String name;

    private String type;

    private Integer barGap;

    private ArrayList<Double> data;

    public Barchart(String name, ArrayList<Double> data) {
        this.name = name;
        this.data = data;
        this.type = "bar";
        this.barGap = 0;
    }
}
