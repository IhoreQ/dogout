import axios from "axios";
import AuthenticationService from "./AuthenticationService";

const getBreeds = () => {
    const token = localStorage.getItem("token");

    return axios.get(
        "/api/dog/breeds", {
        headers: {
            "Authorization": `Bearer ${token}`,
            "Access-Control-Allow-Origin": '*',
            'Accept': 'application/json',
            'Content-Type': 'application/json'
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

const exportedFunctions = {
    getBreeds
}

export default exportedFunctions;