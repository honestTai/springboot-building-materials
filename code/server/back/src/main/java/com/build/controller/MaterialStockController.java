package com.build.controller;

import com.build.common.Result;
import com.build.common.VerifyToken;
import com.build.entity.MaterialStock;
import com.build.service.MaterialStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 建筑材料接口
 */
@RestController
@RequestMapping(value = "/materialStock")
public class MaterialStockController {

    @Autowired
    private MaterialStockService materialStockService;

    @VerifyToken
    @RequestMapping(value = "/queryMaterial", method = RequestMethod.GET)
    public Result queryMaterial(String materialNumber, String materialName,Integer materialQuantity, Integer supplierId, Integer factoryId, Integer materialCategoryId, Integer pageIndex, Integer pageSize) {
        return this.materialStockService.queryMaterialStock(materialNumber, materialName,materialQuantity, supplierId, factoryId, materialCategoryId, pageIndex, pageSize);
    }

    @VerifyToken
    @RequestMapping(value = "/addMaterial", method = RequestMethod.POST)
    public Result addMaterial(MaterialStock materialStock){
        return this.materialStockService.addMaterial(materialStock);
    }

    @VerifyToken
    @RequestMapping(value = "/editMaterial", method = RequestMethod.POST)
    public Result editMaterial(MaterialStock materialStock){
        return this.materialStockService.editMaterial(materialStock);
    }

    @VerifyToken
    @RequestMapping(value = "/delMaterial", method = RequestMethod.GET)
    public Result delMaterial(Integer[] ids) {
        return this.materialStockService.delMaterial(ids);
    }

    @VerifyToken
    @GetMapping("/searchMaterialAndCategory")
    public Result searchMaterialAndCategory() {
        return this.materialStockService.searchMaterialAndCategory();
    }

    @VerifyToken
    @GetMapping("/queryMaterialInCategory")
    public Result queryMaterialInCategory(Integer siteId) {
        return this.materialStockService.queryMaterialInCategory(siteId);
    }
}
