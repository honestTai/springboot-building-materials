import request from '../utils/request';
import qs from 'qs'

export const queryByLimitAccountName = (query) => {
    return request({
        url: 'user-app/account/queryByLimitAccountName',
        method: 'get',
        params: query
    });
};

export const delAccount = (data) => {
    return request({
        url: 'user-app/account/deleteAccount',
        method: 'get',
        params: {
            ids: data
        },
        paramsSerializer: params => {
            return qs.stringify(params, { indices: false })
        }
    })
};

export const addAccount = (data) => {
    return request({
        url: 'user-app/account/addAccount',
        method: 'post',
        data: qs.stringify(data)
    });
};

export const updateAccount = (data) => {
    return request({
        url: 'user-app/account/updateAccount',
        method: 'post',
        data: qs.stringify(data)
    });
};

export const queryRightByUserId = (query) => {
    return request({
        url: 'user-app/account/getAccountRight',
        method: 'get',
        params: query
    });
};

export const updateAccountRight = (data,userId) => {
    return request({
        url: 'user-app/account/updateAccountRight',
        method: 'post',
        params: {
            checkedValue: data,
            userId: userId
        },
        paramsSerializer: params => {
            return qs.stringify(params, { indices: false })
        }
    });
};

