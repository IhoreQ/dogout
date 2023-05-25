import React from "react";
import authenticationService from "../../api/service/authenticationService";
import { Outlet, Navigate } from "react-router-dom";

const UserRoutes = () => {
    const state = authenticationService.isUserLoggedIn();
    return state ? <Outlet /> : <Navigate to="/login" />;
}

export default UserRoutes;