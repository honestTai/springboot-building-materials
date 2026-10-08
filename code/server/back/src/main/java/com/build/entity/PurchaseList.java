package com.build.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 采购清单
 */
@Getter
@Setter
public class PurchaseList {
    private Integer id;

    private String purchaseMaterialName;

    private Integer purchasePlanId;

    private Integer purchaseQuantity;

    private String purchaseUnit;

    private Integer supplierId;

    private String supplierName;

    private Double purchasePrice;
}
