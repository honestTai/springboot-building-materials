package com.build.dao;

import com.build.entity.MaterialStock;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 建筑材料
 */
@Mapper
public interface MaterialStockDao {

    List<MaterialStock> queryMateial(String materialNumber, String materialName, Integer supplierId, Integer factoryId, Integer materialCategoryId, Integer offset, Integer limit);

    Integer queryMaterialCount(String materialNumber, String materialName, Integer supplierId, Integer factoryId, Integer materialCategoryId);

    Integer insertMaterial(MaterialStock materialStock);

    Integer checkMaterialDup(String materialName,String norm, String materialQuality, Integer id);

    Integer updateMaterial(MaterialStock materialStock);

    Integer delMaterial(Integer[] ids);

    Integer checkMaterial(String materialNumber, String materialName, String norm, String materialQuality);

    Integer searchIdByNumber(String materialNumber);

    Integer addMaterialQuantity(Integer id, Integer materialQuantity);

    List<MaterialStock> searchMaterialAndCategoryInQuotePrice();

    Integer queryQuantityById(Integer id);

    List<MaterialStock> queryMaterialInCategoryNotIncludeUsageMaterial(List<Integer> list);

}
