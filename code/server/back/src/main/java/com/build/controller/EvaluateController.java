package com.build.controller;

import com.build.common.Result;
import com.build.common.VerifyToken;
import com.build.entity.Evaluate;
import com.build.service.EvaluateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 评论相关接口
 */
@RestController
@RequestMapping("/evaluate")
public class EvaluateController {

    @Resource
    private EvaluateService evaluateService;

    @VerifyToken
    @PostMapping("/addEvaluate")
    public Result addEvaluate(Evaluate evaluate) {
        return this.evaluateService.addEvaluate(evaluate);
    }

    @VerifyToken
    @GetMapping("/queryEvaluateByPurchasePlanId")
    public Result queryEvaluateByPurchasePlanId(Integer purchasePlanId) {
        return this.evaluateService.queryEvaluate(purchasePlanId);
    }

    @VerifyToken
    @GetMapping("/getFactoryEvaluate")
    public Result getEvaluateFactory(Integer factoryId, Integer factoryPoint, String factoryComment, Integer pageIndex, Integer pageSize) {
        return this.evaluateService.getFactoryEvaluate(factoryId, factoryPoint, factoryComment, pageIndex, pageSize);
    }

    @VerifyToken
    @GetMapping("/getSupplierEvaluate")
    public Result getEvaluateSupplier(Integer supplierId, Integer supplierPoint, String supplierComment, Integer pageIndex, Integer pageSize) {
        return this.evaluateService.getSupplierEvaluate(supplierId, supplierPoint, supplierComment, pageIndex, pageSize);
    }
}
