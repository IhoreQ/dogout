import axios from "axios";

class PlaceService {

    getAllPlaces = async () => {

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