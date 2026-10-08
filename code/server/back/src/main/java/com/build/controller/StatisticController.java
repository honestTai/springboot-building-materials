package com.build.controller;

import com.build.common.Result;
import com.build.common.VerifyToken;
import com.build.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统首页统计接口
 */
@RestController
@RequestMapping(value = "/statistic")
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @VerifyToken
    @GetMapping("/statisticTotalPurchase")
    public Result statisticTotalPurchase() {
        return statisticService.statisticTotalPurchase();
    }

    @VerifyToken
    @GetMapping("/statisticBySelect")
    public Result statisticByUserSelect(Integer type, String startDate, String endDate) throws Exception {
        return statisticService.statisticBySelect(type, startDate, endDate);
    }
}
