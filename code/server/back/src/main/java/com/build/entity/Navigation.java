package com.build.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 导航
 */
@Getter
@Setter
public class Navigation implements Serializable {

    private static final long serialVersionUID = 538759017877598263L;

    private Integer id;

    private String navigationName;

    private String navigationRoute;

    private Integer isDelete;
}
