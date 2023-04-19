import React from "react";
import { Link, useNavigate } from "react-router-dom";
import PersonIcon from '@mui/icons-material/Person';
import LockIcon from '@mui/icons-material/Lock';
import AuthenticateUser from '../../api/auth/AuthenticateUser';

const LoginForm = ({setMessage}) => {

    const navigate = useNavigate();

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

        if (!validateEmail()) {
            setMessage("Provided wrong email!");
        } 
        else if (!validatePassword()) {
            setMessage("Password is too short!");
        }
        else {
            // TODO proces logowania

            const res = await AuthenticateUser(userInfo);
            console.log(res.data);

            if (res.status === 200) {
                setUserInfo({
                    email: "",
                    password: ""
                })
                setMessage("");
        
                navigate("/home");
            } else {
                console.log("Error");
            }
            
        }
    }

    return (
        <form className="login-form">
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
            <button onClick={loginClicked} type="submit" className="blue-button">Log in</button>
            <div className="sign-up-text">
                Don't have an account? <span><Link to="/signup">Sign up</Link></span>
            </div>
        </form>
    )
}

export default LoginForm;