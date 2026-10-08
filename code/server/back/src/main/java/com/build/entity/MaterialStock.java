package com.build.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 建筑材料库存
 */
@Getter
@Setter
public class MaterialStock {

    private Integer id;

    private String materialNumber;

    private String materialName;

    private Integer supplierId;

    private String supplierName;

    private Integer factoryId;

    private String factoryName;

    private Integer materialQuantity;

    private String materialUnit;

    private Integer materialLow;

    private Integer materialHigh;

    private Integer materialCategoryId;

    private String materialCategoryName;

    private Integer isDelete;

    private String norm;

    private String materialQuality;

    private List<MaterialStock> child;
}
