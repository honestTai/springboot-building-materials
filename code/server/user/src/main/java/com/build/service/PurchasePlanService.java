package com.build.service;

import com.build.common.Result;

/**
 * (PurchasePlan)表服务接口
 */
public interface PurchasePlanService {

    Result queryById(Integer id);

    Result queryPurchasePlanWithLimit(String token, String purchaseNumber, Integer state, String startTime, String endTime, Integer pageIndex, Integer pageSize);

    Result approvalPurchasePlan(String token, Integer purchasePlanId, Integer state, String approvalNote, Double dealMoney);

    Result delPurchasePlan(Integer[] ids);

    Result applyPurchasePlan(String token, String applyNote, Integer materialId, Integer purchaseQuantity, Integer supplierId);

    Result getApprovalPlan();

    Result donePurchasePlan(Integer id);

    Result updatePurchasePlanToHavaBuy(Integer id);
}