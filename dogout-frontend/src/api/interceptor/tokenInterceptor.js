import axios from "axios";

const api = axios.create({
    baseURL: '/api',
});

api.interceptors.request.use(
    config => {
        const token = localStorage.getItem("token");
        if (token) {
            config.headers['Authorization'] = `Bearer ${token}`;
        }
        config.headers['Access-Control-Allow-Origin'] = '*';
        config.headers['Accept'] = 'application/json';
        config.headers['Content-Type'] = 'application/json';
        return config;
    },
    error => {
        return Promise.reject(error);
    }
)

api.interceptors.response.use(
    response => {
        return response;
    },
    error => {
        if (error.response) {
            return Promise.reject(error.response);
        }
        else if (error.request) {
            return Promise.reject("The connection has timed out.");
        }
        else {
            return Promise.reject("An error occured.")
        }
    }
)

export default api;