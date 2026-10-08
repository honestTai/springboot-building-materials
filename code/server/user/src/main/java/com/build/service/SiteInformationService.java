package com.build.service;

import com.build.common.Result;
import com.build.entity.SiteInformation;

/**
 * 工地信息service
 */
public interface SiteInformationService {

    Result querySiteInformation(String siteName, Integer siteState, Integer pageIndex, Integer pageSize);

    Result getSiteInformationById(Integer id);

    Result delSiteInformation(Integer[] ids);

    Result updateSiteInformaiton(SiteInformation siteInformation);

    Result addSiteInfomation(SiteInformation siteInformation);

    Result addUsage(Integer siteId, Integer materialId, Integer putQuantity);

    Result querySiteMaterialUsage(Integer siteId, String materialName, Integer type, Integer pageIndex, Integer pageSize);

    Result appendUsage(Integer id, Integer materialId, Integer putQuantity);

    Result updateUseQuantity(Integer id, Integer useQuantity);
}
