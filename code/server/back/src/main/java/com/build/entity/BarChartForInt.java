package com.build.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * 图形数据
 */
@Getter
@Setter
public class BarChartForInt {
    private String name;

    private String type;

    private Integer barGap;

    private ArrayList<Integer> data;

    public BarChartForInt(String name, ArrayList<Integer> data) {
        this.name = name;
        this.data = data;
        this.type = "bar";
        this.barGap = 0;
    }
}
