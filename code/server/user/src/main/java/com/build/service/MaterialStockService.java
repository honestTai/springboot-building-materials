package com.build.service;

import com.build.common.Result;
import com.build.entity.MaterialStock;

/**
 * 材料库存service
 */
public interface MaterialStockService {

    Result queryMaterialStock(String materialNumber, String materialName,Integer materialQuantity, Integer supplierId, Integer factoryId, Integer materialCategoryId, Integer offset, Integer limit);

    Result addMaterial(MaterialStock materialStock);

    Result editMaterial(MaterialStock materialStock);

    Result delMaterial(Integer[] ids);

    Result searchMaterialAndCategory();

    Result queryMaterialInCategory(Integer siteId);
}
