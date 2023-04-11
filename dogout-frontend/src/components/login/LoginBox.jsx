import React from "react";
import Logo from "../Logo";
import LoginForm from "./LoginForm";


const LoginBox = () => {

    const [message, setMessage] = React.useState("");

    return (
        <div className="login-container">
            <div className="login-inner-container">
                <Logo />
                <div className="message">
                    {message}
                </div>
                <LoginForm setMessage={setMessage} />
            </div>
        </div>
    )
}

export default LoginBox;