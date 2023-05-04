import React from "react";
import Logo from "../common/Logo";
import RegisterForm from "./SignUpForm";


const LoginBox = () => {

    const [message, setMessage] = React.useState("");

    return (
        <div className="login-container">
            <div className="login-inner-container">
                <Logo />
                <div className="message">
                    {message}
                </div>
                <RegisterForm setMessage={setMessage} />
            </div>
        </div>
    )
}

export default LoginBox;