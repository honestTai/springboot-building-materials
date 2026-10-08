import request from '../utils/request';
import qs from 'qs'

export const queryFactory = (query) => {
    return request({
        url: 'back-app/factory/queryFactory',
        method: 'get',
        params: query
    });
};

export const updateFactory = (data) => {
    return request({
        url: 'back-app/factory/editFactory',
        method: 'post',
        data: qs.stringify(data)
    });
};

export const addFactory = (data) => {
    return request({
        url: 'back-app/factory/addFactory',
        method: 'post',
        data: qs.stringify(data)
    });
};

export const delFactory = (data) => {
    return request({
        url: 'back-app/factory/deleteFactory',
        method: 'get',
        params: {
            ids: data
        },
        paramsSerializer: params => {
            return qs.stringify(params, { indices: false })
        }
    })
};

export const queryFactoryAll = () => {
    return request({
        url: 'back-app/factory/queryFactoryAll',
        method: 'get'
    });
};
