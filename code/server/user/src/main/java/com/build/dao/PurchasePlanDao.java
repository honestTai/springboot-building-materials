package com.build.dao;

import com.build.entity.MaterialStock;
import com.build.entity.PurchasePlan;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (PurchasePlan)表数据库访问层
 */
@Mapper
public interface PurchasePlanDao {

    PurchasePlan queryById(Integer id);

    List<PurchasePlan> queryDataWithLimit(String myId, String purchaseNumber, Integer state, String startTime, String endTime, Integer offset, Integer limit);

    Integer queryDataCountWithLimit(String myId, String purchaseNumber, Integer state, String startTime, String endTime);

    PurchasePlan queryPurchasePlanById(Integer id);

    Integer approvalPurchasePlan(String approvalUserId, Integer id, Integer state, String approvalNote, Double dealMoney);

    Integer delPurchasePlan(Integer[] ids);

    Integer addPurchasePlan(PurchasePlan purchasePlan);

    List<MaterialStock> getApprovalPurchase();

    Integer updateStateOver(Integer id);

    List<PurchasePlan> statisticTotalPurchase();

    List<PurchasePlan> statisticByUseSelect(String startDate, String endDate);

    Integer updatePurchasePlanToHavaBuy(Integer id);
}