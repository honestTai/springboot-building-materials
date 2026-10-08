import request from '../utils/request';
import qs from 'qs'

export const login = (userName, password) => {
    let data = {"userName": userName, "password": password};
    return request({
        url: 'user-app/auth/login',
        method: 'post',
        data: qs.stringify(data)
    });
};

export const updatePassword = (data) => {
    //let data = {"userName": userName, "password": password};
    return request({
        url: 'user-app/auth/updatePassword',
        method: 'post',
        data: qs.stringify(data)
    });
};
