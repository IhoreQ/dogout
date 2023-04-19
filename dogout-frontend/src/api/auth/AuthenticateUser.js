import axios from "axios";

const AuthenticateUser = (userInfo) => {
    return axios.post(
        "http://localhost:8080/api/auth/authenticate",
        userInfo
    ).then((res) => {  
        if (res != null) {
            return res;
        }
    })
    .catch(err => {
        let error = "";
        if (err.response)
            error += err.response;
        return error;
    })
}

export default AuthenticateUser;