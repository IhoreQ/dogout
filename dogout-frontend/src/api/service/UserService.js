import axios from "axios";
import AuthenticationService from "./AuthenticationService";

const getActiveWalk = async () => {
    const token = localStorage.getItem("token");
    const email = localStorage.getItem("email");

    return axios.get(
        "/api/walk", {
        headers: {
            "Authorization": `Bearer ${token}`,
            "Access-Control-Allow-Origin": '*',
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        params: {
            "email": email
        }
    }).then(res => {
        if (res != null)
            return res;
    })
        .catch(err => {
            AuthenticationService.logout();
            let error = "";
            if (err.response)
                error += err.response;
            return error;
        });
}

const getDoggy = async () => {
    const token = localStorage.getItem("token");
    const email = localStorage.getItem("email");

    return await axios.get(
        "/api/dog", {
        headers: {
            "Authorization": `Bearer ${token}`,
            "Access-Control-Allow-Origin": '*',
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        params: {
            "email": email
        }
    }).then(res => {
        if (res != null)
            return res;
    }).catch(err => {
        AuthenticationService.logout();
        let error = "";
        if (err.response)
            error += err.response;
        return error;
    });
}

const finishWalk = async () => {
    const token = localStorage.getItem("token");
    const email = localStorage.getItem("email");

    return await axios.delete(
        "/api/walk", {
        headers: {
            "Authorization": `Bearer ${token}`,
            "Access-Control-Allow-Origin": '*',
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        params: {
            "email": email
        }
    }).then(res => {
        if (res != null)
            return res;
    }).catch(err => {
        AuthenticationService.logout();
        let error = "";
        if (err.response)
            error += err.response;
        return error;
    });
}

const deleteDoggy = async () => {
    const token = localStorage.getItem("token");
    const email = localStorage.getItem("email");

    return await axios.delete(
        "/api/dog", {
        headers: {
            "Authorization": `Bearer ${token}`,
            "Access-Control-Allow-Origin": '*',
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        params: {
            "email": email
        }
    }).then(res => {
        if (res != null)
            return res;
    }).catch(err => {
        AuthenticationService.logout();
        let error = "";
        if (err.response)
            error += err.response;
        return error;
    });
}

export default {
    getActiveWalk,
    getDoggy,
    finishWalk,
    deleteDoggy
};