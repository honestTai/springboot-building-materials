import request from '../utils/request';
import qs from 'qs'

export const statisticPurchase = () => {
    return request({
        url: 'back-app/statistic/statisticTotalPurchase',
        method: 'get',
    });
};

export const statisticBySelect = (data) => {
    return request({
        url: 'back-app/statistic/statisticBySelect',
        method: 'get',
        params: data
    });
};
