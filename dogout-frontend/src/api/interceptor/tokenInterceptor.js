import axios from "axios";
import authenticationService from "../service/authenticationService";

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
    async (error) => {
        if (error.response) {
            if (error.response.status === 401) {
                // REFRESH TOKEN
                authenticationService.logout();
                window.location.reload();
            }
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