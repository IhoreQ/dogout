import React from "react";
import Logo from "../common/Logo";
import RegisterForm from "./SignUpForm";

import "./SignUpBox.css";

const SignUpBox = () => {
    return (
        <div className="signup-container">
            <div className="signup-inner-container">
                <Logo />
                <RegisterForm />
            </div>
        </div>
    )
}

export default SignUpBox;