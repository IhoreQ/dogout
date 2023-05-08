import React from "react";
import AuthenticationService from "../../api/service/AuthenticationService";
import { Navigate, Outlet } from "react-router-dom";

const GuestRoutes = () => {
    const state = AuthenticationService.isUserLoggedIn();
    return state ? <Navigate to="/home" /> : <Outlet />;
}

export default GuestRoutes;