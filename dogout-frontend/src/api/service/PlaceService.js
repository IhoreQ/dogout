import axios from "axios";

class PlaceService {

    getAllPlaces = async () => {

        const token = localStorage.getItem("token");

        return axios.get(
            "http://localhost:8080/api/place/all", {
            headers: {
                "Authorization": `Bearer ${token}`,
                "Access-Control-Allow-Origin": '*',
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
        }).then(res => {
            if (res != null)
                return res;
        })
            .catch(err => {
                let error = "";
                if (err.response)
                    error += err.response;
                return error;
            });
    }
}

export default new PlaceService();