import axios from "axios";

const authenticateUser = async (userInfo) => {
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
                error += err.respfonse;
            return error;
        })
}

const signup = async (userInfo) => {
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

const logout = () => {
    localStorage.clear();
    sessionStorage.clear();
}

const setLoggedInUser = (email) => {
    localStorage.setItem("email", email);
}

const setToken = (jwtToken) => {
    localStorage.setItem("token", jwtToken);
}

const isUserLoggedIn = () => {
    let user = localStorage.getItem("email");
    return user == null ? false : true;
}

const getUserEmail = () => {
    let email = localStorage.getItem("email");
    if (email == null)
        return "";
    else
        return email;
}

const exportedFunctions = {
    authenticateUser,
    signup,
    logout,
    setLoggedInUser,
    setToken,
    isUserLoggedIn,
    getUserEmail
}

export default exportedFunctions;