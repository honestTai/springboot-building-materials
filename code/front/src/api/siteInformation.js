import request from '../utils/request';
import qs from 'qs'

export const querySiteById = (query) => {
    return request({
        url: 'back-app/siteInformation/querySiteById',
        method: 'get',
        params: query
    });
};

export const querySiteWithLimit = (query) => {
    return request({
        url: 'back-app/siteInformation/querySiteByLimit',
        method: 'get',
        params: query
    });
};

export const delSite = (data) => {
    return request({
        url: 'back-app/siteInformation/delSite',
        method: 'get',
        params: {
            ids: data
        },
        paramsSerializer: params => {
            return qs.stringify(params, { indices: false })
        }
    })
};

export const updateSite = (data) => {
    return request({
        url: 'back-app/siteInformation/updateSite',
        method: 'post',
        data: qs.stringify(data)
    });
};

export const addSite = (data) => {
    return request({
        url: 'back-app/siteInformation/addSite',
        method: 'post',
        data: qs.stringify(data)
    });
};

export const addUsage = (data) => {
    return request({
        url: 'back-app/siteInformation/addUsage',
        method: 'post',
        data: qs.stringify(data)
    });
};

export const getUsage = (query) => {
    return request({
        url: 'back-app/siteInformation/getUsage',
        method: 'get',
        params: query
    });
};

export const appendMaterialTotal = (data) => {
    return request({
        url: 'back-app/siteInformation/appendUsage',
        method: 'post',
        data: qs.stringify(data)
    });
};

export const updateUseQuantity = (data) => {
    return request({
        url: 'back-app/siteInformation/updateUseQuantity',
        method: 'post',
        data: qs.stringify(data)
    });
};
