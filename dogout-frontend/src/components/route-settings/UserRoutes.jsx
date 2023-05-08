import React from "react";
import AuthenticationService from "../../api/service/AuthenticationService";
import { Outlet, Navigate } from "react-router-dom";

const UserRoutes = () => {
    const state = AuthenticationService.isUserLoggedIn();
    return state ? <Outlet /> : <Navigate to="/login" />;
}

export default UserRoutes;