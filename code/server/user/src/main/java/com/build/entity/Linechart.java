package com.build.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * 折线图
 */
@Getter
@Setter
public class Linechart {
    private String name;

    private String type;

    //private String stack;

    private ArrayList<Double> data;

    public Linechart(String name, ArrayList<Double> data) {
        this.name = name;
        this.type = "line";
        //this.stack = "总量";
        this.data = data;
    }
}
