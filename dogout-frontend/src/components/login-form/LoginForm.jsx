import React from "react";
import { Link, useNavigate } from "react-router-dom";
import PersonIcon from '@mui/icons-material/Person';
import LockIcon from '@mui/icons-material/Lock';
import authenticationService from '../../api/service/authenticationService';
import SignButton from "../common/SignButton";

import "./LoginForm.css";

const LoginForm = () => {

    const navigate = useNavigate();

    const [message, setMessage] = React.useState("");
    const [userInfo, setUserInfo] = React.useState({
        email: "",
        password: ""
    });

    const changeInfo = (event) => {
        const { name, value } = event.target;

        setUserInfo(prevInfo => {
            return {
                ...prevInfo,
                [name]: value
            }
        });
    }

    const validateEmail = () => {
        return userInfo.email.match(/^([\w.%+-]+)@([\w-]+\.)+([\w]{2,})$/);
    }

    const validatePassword = () => {
        return userInfo.password.length >= 6;
    }

    const loginClicked = async (event) => {
        event.preventDefault();

        if (!validateEmail() & !validatePassword()) {
            setMessage("Email and password are incorrect!");
        }
        else if (!validateEmail()) {
            setMessage("Provided wrong email!");
        }
        else if (!validatePassword()) {
            setMessage("Password is too short!");
        }
        else {
            const res = await authenticationService.authenticateUser(userInfo);

            if (res.status === 200) {
                if (res.data.jwtToken.length === 0) {
                    setMessage("Provided wrong email or password!");
                    setUserInfo({
                        email: userInfo.email,
                        password: ""
                    })
                } else {
                    const jwtToken = res.data.jwtToken;
                    authenticationService.setToken(jwtToken);
                    navigate("/home");
                }
            } else {
                console.log("Error");
            }
        }
    }

    return (
        <form className="login-form">
            <div className="message">{message}</div>
            <div className="input-div">
                <PersonIcon />
                <input value={userInfo.email} onChange={changeInfo} name="email" type="text" placeholder="Email" />
            </div>
            <div className="input-div">
                <LockIcon />
                <input value={userInfo.password} onChange={changeInfo} name="password" type="password" placeholder="Password" />
            </div>
            <div className="forgot-password-text-container">
                <span className="forgot-password-text">Forgot password</span>
            </div>
            <SignButton onClick={loginClicked} type="submit">Log in</SignButton>
            <div className="sign-up-text">
                Don't have an account? <span><Link to="/signup">Sign up</Link></span>
            </div>
        </form>
    )
}

export default LoginForm;