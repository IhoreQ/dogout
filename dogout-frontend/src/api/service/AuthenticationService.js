import axios from "axios";

class AuthenticationService {

    authenticateUser = async (userInfo) => {
        return axios.post(
            "/api/auth/authenticate",
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
    
    signup = async (userInfo) => {
        return axios.post(
            "/api/auth/signup",
            userInfo
        ).then(res => {
            if (res != null)
                return res;
        })
        .catch(err => {
            let error = "";
            if (err.response)
                error += err.response;
            return error;
        })
    }

    logout = () => {
        localStorage.clear();
    }

    setLoggedInUser = (email) => {
        localStorage.setItem("email", email);
    }

    setToken = (jwtToken) => {
        localStorage.setItem("token", jwtToken);
    }

    isUserLoggedIn = () => {
        let user = localStorage.getItem("email");
        if (user == null)
            return false;
        else
            return true;
    }

    getUserEmail = () => {
        let email = localStorage.getItem("email");
        if (email == null)
            return "";
        else
            return email;
    }

}


export default new AuthenticationService();