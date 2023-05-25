import React from "react";
import Logo from "../common/Logo";
import LoginForm from "./LoginForm";

import "./LoginBox.css";

const LoginBox = () => {

    return (
        <div className="login-container">
            <div className="login-inner-container">
                <Logo />
                <LoginForm/>
            </div>
        </div>
    )
}

export default LoginBox;