import request from '../utils/request';
import qs from 'qs'

export const checkPermission = (query) => {
    return request({
        url: 'user-app/auth/checkPermission',
        method: 'get',
        params: query
    });
};

