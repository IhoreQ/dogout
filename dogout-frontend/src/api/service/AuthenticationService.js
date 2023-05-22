import axios from "axios";

const authenticateUser = async (userInfo) => {
    try {
        return await axios.post("/api/auth/authenticate", userInfo);
    } catch (err) {
        return err.response;
    }
}

const signup = async (userInfo) => {
    try {
        return await axios.post("/api/auth/signup", userInfo);
    } catch (err) {
        return err.response;
    }
}

const logout = () => {
    localStorage.clear();
    sessionStorage.clear();
}

const setToken = (jwtToken) => {
    localStorage.setItem("token", jwtToken);
}

const isUserLoggedIn = () => {
    let user = localStorage.getItem("token");
    return user != null;
}

const exportedFunctions = {
    authenticateUser,
    signup,
    logout,
    setToken,
    isUserLoggedIn
}

export default exportedFunctions;