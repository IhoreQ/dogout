import axios from "axios";
import AuthenticationService from "./AuthenticationService";

const getAllPlaces = async () => {

    const token = localStorage.getItem("token");

    return axios.get(
        "/api/place/all", {
        headers: {
            "Authorization": `Bearer ${token}`,
            "Access-Control-Allow-Origin": '*',
            "Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept",
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    }).then(res => {
        if (res != null)
            return res;
    }).catch(err => {
        // TODO  Zamiast tego wyświetlić komunikat, że sesja wygasła, gdy wystąpi błąd 403 i po kliknięciu wylogować
        AuthenticationService.logout();
        let error = "";
        if (err.response)
            error += err.response;
        return error;
    });
}

const exportedFunctions = {
    getAllPlaces
}

export default exportedFunctions;