package com.build.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 留言，评论
 */
@Getter
@Setter
public class Evaluate {
    private Integer id;

    private Integer supplierId;

    private String supplierComment;

    private Integer factoryId;

    private String factoryComment;

    private Integer supplierPoint;

    private Integer factoryPoint;

    private Integer isDelete;

    private Integer purchasePlanId;

    private Integer userId;

    private String token;

    private String evaluteTime;

    private String username;
}
