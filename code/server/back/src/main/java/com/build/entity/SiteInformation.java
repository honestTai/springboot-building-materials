package com.build.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 工地信息
 */
@Getter
@Setter
public class SiteInformation {
    private Integer id;

    private String siteName;

    private String siteAddress;

    private String siteContact;

    private String contactPhone;

    private Integer siteState;

    private String startDate;

    private String expectedEndDate;

    private String factEndDate;

    private Integer isDelete;
}
