import React from "react";
import authenticationService from "../../api/service/authenticationService";
import { Navigate, Outlet } from "react-router-dom";

const GuestRoutes = () => {
    const state = authenticationService.isUserLoggedIn();
    return state ? <Navigate to="/home" /> : <Outlet />;
}

export default GuestRoutes;