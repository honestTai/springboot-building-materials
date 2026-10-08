package com.build.dao;

import com.build.entity.Evaluate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 评论相关的Dao
 */
@Mapper
public interface EvaluateDao {

    Integer insertEvaluate(Evaluate evaluate);

    Evaluate queryByPurchasePlanId(Integer purchasePlanId);

    List<Evaluate> getFactoryEvaluate(Integer factoryId, Integer factoryPoint, String factoryComment, Integer offset, Integer limit);

    List<Evaluate> getSupplierEvaluate(Integer supplierId, Integer supplierPoint, String supplierComment, Integer offset, Integer limit);

    Integer getFacotryEvaluateCount(Integer factoryId, Integer factoryPoint, String factoryComment);

    Integer getSupplierEvaluateCount(Integer supplierId, Integer supplierPoint, String supplierComment);
}
