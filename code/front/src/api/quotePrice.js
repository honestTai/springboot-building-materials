import request from '../utils/request';
import qs from 'qs'

export const queryQuotePrice = (query) => {
    return request({
        url: 'back-app/quotePrice/queryQuotePrice',
        method: 'get',
        params: query
    });
};

export const delQuotePrice = (data) => {
    return request({
        url: 'back-app/quotePrice/delQuotePrice',
        method: 'get',
        params: {
            ids: data
        },
        paramsSerializer: params => {
            return qs.stringify(params, { indices: false })
        }
    })
};

export const downloadTempQuotePrice = () => {
    return request({
        url: 'back-app/quotePrice/downloadQuotePriceTemp',
        method: 'post',
        responseType: 'blob'
    });
};

export const uploadQuotePriceData = (data) => {
    return request({
        headers: {
            'Content-Type': 'multipart/form-data'
        },
        url: 'back-app/quotePrice/uploadQuotePriceData',
        method: 'post',
        data: data
    });

};

export const searchSupplierByMaterialId = (data) => {
    return request({
        url: 'back-app/quotePrice/searchSupplierByMaterialId',
        method: 'post',
        data: qs.stringify(data)
    });
};




export const analysisQuotePrice = (data) => {
    let data1 = {"materialId": data.materialId, "startDate": data.dateRange[0], "endDate": data.dateRange[1]};
    return request({
        url: 'back-app/quotePrice/analysisQuotePrice',
        method: 'get',
        params: data1
    })
};
