import axios from "axios";
import AuthenticationService from './AuthenticationService';

const getDogs = async (id) => {
    const token = localStorage.getItem("token");

    return await axios.get(
        `/api/walk/${id}`,
        {
            headers: {
                "Authorization": `Bearer ${token}`,
                "Access-Control-Allow-Origin": '*',
                'Accept': 'application/json',
                'Content-Type': 'application/json'
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

const goForAWalk = async (walkInfo) => {
    const token = localStorage.getItem("token");

    return await axios.post(
        "/api/walk",
        walkInfo, {
        headers: {
            "Authorization": `Bearer ${token}`,
            "Access-Control-Allow-Origin": '*',
            'Accept': 'application/json',
            'Content-Type': 'application/json'
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

const exportedFunctions = {
    getDogs,
    goForAWalk
}

export default exportedFunctions;