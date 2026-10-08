import request from '../utils/request';
import qs from 'qs'

export const queryByLimitNavigation = (query) => {
    return request({
        url: 'back-app/navigation/queryByLimitNavigation',
        method: 'get',
        params: query
    });
};

export const updateNavigation = (data) => {
    return request({
        url: 'back-app/navigation/editNavigation',
        method: 'post',
        data: qs.stringify(data)
    });
};

export const addNavigation = (data) => {
    return request({
        url: 'back-app/navigation/addNavigation',
        method: 'post',
        data: qs.stringify(data)
    });
};

export const delNavigation = (data) => {
    return request({
        url: 'back-app/navigation/deleteNavigation',
        method: 'get',
        params: {
            ids: data
        },
        paramsSerializer: params => {
            return qs.stringify(params, { indices: false })
        }
    })
};
