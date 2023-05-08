import React from "react";
import AuthenticationService from "../api/service/AuthenticationService";
import { useNavigate } from "react-router-dom";


const Home = () => {

    const navigate = useNavigate();
    
    return (
        <button onClick={() => {
            AuthenticationService.logout();
            navigate("/login");
        }}>Wyloguj</button>
    )
}

export default Home;