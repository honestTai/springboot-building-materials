import request from '../utils/request';
import qs from 'qs'

export const queryPurchasePlanWithLimit = (query) => {
    return request({
        url: 'back-app/purchasePlan/queryPurchasePlan',
        method: 'get',
        params: query
    });
};

export const queryPurchaseList = (id) => {
    return request({
        url: 'back-app/purchasePlan/purchaseListDetail?id='+id,
        method: 'get',
    });
};

export const approvalPurchasePlan = (data) => {
    return request({
        url: 'back-app/purchasePlan/approvalPurchasePlan',
        method: 'get',
        params: data
    });
};


export const delPurchasePlan = (data) => {
    return request({
        url: 'back-app/purchasePlan/delPurchasePlan',
        method: 'get',
        params: {
            ids: data
        },
        paramsSerializer: params => {
            return qs.stringify(params, { indices: false })
        }
    })
};

export const applyPurchasePlan = (data) => {
    return request({
        url: 'back-app/purchasePlan/applyPurchase',
        method: 'post',
        data: qs.stringify(data)
    });
};

export const getApprovalPurchase = () => {
    return request({
        url: 'back-app/purchasePlan/getApprovalPurchase',
        method: 'get',
    });
};

export const putInStock = (data) => {
    return request({
        url: 'back-app/purchasePlan/putInStock',
        method: 'post',
        data: qs.stringify(data)
    });
};

export const updatePurchasePlanToHavaBuy = (data) => {
    return request({
        url: 'back-app/purchasePlan/updatePurchasePlanToHavaBuy',
        method: 'post',
        data: qs.stringify(data)
    });
};


