package com.build.service;

import com.build.common.Result;
import com.build.entity.Evaluate;

/**
 * 评论服务
 */
public interface EvaluateService {

    Result addEvaluate(Evaluate evaluate);

    Result queryEvaluate(Integer purchasePlanId);

    Result getFactoryEvaluate(Integer factoryId, Integer factoryPoint, String factoryComment, Integer pageIndex, Integer pageSize);

    Result getSupplierEvaluate(Integer supplierId, Integer supplierPoint, String supplierComment, Integer pageIndex, Integer pageSize);
}
