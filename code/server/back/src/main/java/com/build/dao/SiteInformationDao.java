package com.build.dao;

import com.build.entity.SiteInformation;
import com.build.entity.SiteUsage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 工地信息
 */
@Mapper
public interface SiteInformationDao {

    List<SiteInformation> querySiteInformation(String siteName, Integer siteState, Integer offset, Integer limit);

    Integer querySiteCount(String siteName, Integer siteState);

    Integer delSiteInformation(Integer[] ids);

    SiteInformation queryById(Integer id);

    Integer updateSiteInformation(SiteInformation siteInformation);

    Integer addSiteInformation(SiteInformation siteInformation);

    List<SiteUsage> querySiteUsageById(Integer siteId, String materialName, Double startPercent, Double endPercent, Integer offset, Integer limit);

    Integer querySiteUsageByIdCount(Integer siteId, String materialName, Double startPercent, Double endPercent);

    Integer addUsageForSite(Integer siteId, Integer materialId, Integer putQuantity);

    List<Integer> queryUsage(Integer siteId);

    Integer appendMaterial(Integer id, Integer putQuantity);

    Integer updateUseQuantity(Integer id, Integer useQuantity);

    SiteUsage queryUseById(Integer id);

    Integer queryTotalUseQuantity();
}
