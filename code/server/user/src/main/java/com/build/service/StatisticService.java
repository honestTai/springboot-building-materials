package com.build.service;

import com.build.common.Result;


/**
 * 统计service
 */
public interface StatisticService {


    Result statisticTotalPurchase();

    Result statisticBySelect(Integer type, String startDate, String endDate) throws Exception;
}
