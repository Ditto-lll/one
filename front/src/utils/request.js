import axios from 'axios';

// 根据当前环境选择 baseURL
// 如果是本地开发（localhost），用本地地址；否则用公网地址
const isLocal = window.location.hostname === 'localhost' || window.location.hostname === '127.0.0.1';
const baseURL = isLocal
    ? 'http://localhost:8080'
    : 'https://28de0a9.r16.cpolar.top';  // 你的后端公网地址


const service = axios.create({
    timeout: 5000,
    baseURL: '',  // ← 改成空字符串
    withCredentials: true
});

service.interceptors.request.use(
    config => {
        return config;
    },
    error => {
        console.log(error);
        return Promise.reject();
    }
);

service.interceptors.response.use(
    response => {
        if (response.status === 200) {
            return response.data;
        } else {
            Promise.reject();
        }
    },
    error => {
        console.log(error);
        return Promise.reject();
    }
);

export default service;