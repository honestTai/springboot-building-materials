package com.build.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class SelectOptions {

    private Integer value;

    private String label;

    private List<SelectOptions> children;

    public SelectOptions() {
    }

    public SelectOptions(Integer value, String label) {
        this.value = value;
        this.label = label;
    }

    public SelectOptions(Integer value, String label, List<SelectOptions> children) {
        this.value = value;
        this.label = label;
        this.children = children;
    }
}
