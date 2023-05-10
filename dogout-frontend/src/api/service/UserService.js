import axios from "axios";

class UserService {

    getActiveWalk = async () => {
        const token = localStorage.getItem("token");
        const email = localStorage.getItem("email");

        return axios.get(
            "http://localhost:8080/api/walk", {
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
                let error = "";
                if (err.response)
                    error += err.response;
                return error;
            });
    }

    getDoggy = async () => {
        const token = localStorage.getItem("token");
        const email = localStorage.getItem("email");

        return axios.get(
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
        })
            .catch(err => {
                let error = "";
                if (err.response)
                    error += err.response;
                return error;
            });
    }
}

export default new UserService();