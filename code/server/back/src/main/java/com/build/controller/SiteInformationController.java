package com.build.controller;

import com.build.common.Result;
import com.build.common.VerifyToken;
import com.build.entity.SiteInformation;
import com.build.service.SiteInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 建筑工地信息
 */
@RestController
@RequestMapping(value = "/siteInformation")
public class SiteInformationController {

    @Autowired
    private SiteInformationService siteInformationService;

    @GetMapping("/querySiteById")
    @VerifyToken
    public Result querySiteById(Integer id) {
        return this.siteInformationService.getSiteInformationById(id);
    }

    @GetMapping("/querySiteByLimit")
    @VerifyToken
    public Result querySiteByLimit(String siteName, Integer siteState, Integer pageIndex, Integer pageSize) {
        return this.siteInformationService.querySiteInformation(siteName, siteState, pageIndex, pageSize);
    }

    @VerifyToken
    @PostMapping("/updateSite")
    public Result updateSite(SiteInformation siteInformation) {
        return this.siteInformationService.updateSiteInformaiton(siteInformation);
    }

    @VerifyToken
    @PostMapping("/addSite")
    public Result addSite(SiteInformation siteInformation) {
        return this.siteInformationService.addSiteInfomation(siteInformation);
    }

    @VerifyToken
    @GetMapping("/delSite")
    public Result delSite(Integer[] ids) {
        return this.siteInformationService.delSiteInformation(ids);
    }

    @VerifyToken
    @PostMapping("/addUsage")
    public Result addUsage(Integer siteId, Integer materialId, Integer putQuantity) {
        return this.siteInformationService.addUsage(siteId, materialId, putQuantity);
    }

    @VerifyToken
    @GetMapping("/getUsage")
    public Result getUsage(Integer siteId, String materialName, Integer type, Integer pageIndex, Integer pageSize) {
        return this.siteInformationService.querySiteMaterialUsage(siteId, materialName, type, pageIndex, pageSize);
    }

    @VerifyToken
    @PostMapping("/appendUsage")
    public Result appendUsage(Integer id, Integer materialId, Integer putQuantity) {
        return this.siteInformationService.appendUsage(id, materialId, putQuantity);
    }

    @VerifyToken
    @PostMapping("/updateUseQuantity")
    public Result updateUseQuantity(Integer id, Integer useQuantity) {
        return this.siteInformationService.updateUseQuantity(id, useQuantity);
    }
}
