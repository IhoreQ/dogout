import React from "react";
import { Link, useNavigate } from "react-router-dom";
import PersonIcon from '@mui/icons-material/Person';
import LockIcon from '@mui/icons-material/Lock';
import BadgeIcon from '@mui/icons-material/Badge';
import SignButton from "../common/SignButton";
import AuthenticationService from "../../api/service/AuthenticationService";

import "./SignUpForm.css";

const SignUpForm = () => {

    const navigate = useNavigate();

    const [message, setMessage] = React.useState("");
    const [userInfo, setUserInfo] = React.useState({
        firstName: "",
        lastName: "",
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

    const validateDetails = () => {
        const pattern = /^(?=.{1,256}$)[A-ZĆŁŚŻŹa-ząćęńóśżź\\p{L}]+['-]?[A-ZĆŁŚŻŹa-ząćęńóśżź]+/;
        return userInfo.firstName.match(pattern) && userInfo.lastName.match(pattern);
    }

    const signUpClicked = async (event) => {
        event.preventDefault();

        if (!validateEmail() & !validatePassword() & !validateDetails()) {
            setMessage("Whole data is wrong!");
        }
        else if (!validateDetails()) {
            setMessage("Provided wrong name or last name!");
        }
        else if (!validateEmail()) {
            setMessage("Provided wrong email!");
        } 
        else if (!validatePassword()) {
            setMessage("Provided wrong password!");
        }
        else {
            const response = await AuthenticationService.signup(userInfo);
            
            if (response.status === 201) {
                navigate("/login");
            } else {
                setMessage("User with this email already exist!");
            }
        }
    }

    return (
        <form className="signup-form">
            <div className="message sign-up-message">{message}</div>
            <div className="input-div">
                <BadgeIcon />
                <input value={userInfo.firstName} onChange={changeInfo} name="firstName" type="text" placeholder="First name" />
            </div>
            <div className="input-div">
                <BadgeIcon />
                <input value={userInfo.lastName} onChange={changeInfo} name="lastName" type="text" placeholder="Last name" />
            </div>
            <div className="input-div">
                <PersonIcon />
                <input value={userInfo.email} onChange={changeInfo} name="email" type="text" placeholder="Email" />
            </div>
            <div className="input-div">
                <LockIcon />
                <input value={userInfo.password} onChange={changeInfo} name="password" type="password" placeholder="Password" />
            </div>
            <SignButton onClick={signUpClicked} type="submit">Sign up</SignButton>
            <div className="sign-up-text">
                Don't have an account? <span><Link to="/login">Sign in</Link></span>
            </div>
        </form>
    )
}

export default SignUpForm;