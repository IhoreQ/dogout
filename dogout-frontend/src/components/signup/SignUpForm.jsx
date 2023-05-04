import React from "react";
import { Link, useNavigate } from "react-router-dom";
import PersonIcon from '@mui/icons-material/Person';
import LockIcon from '@mui/icons-material/Lock';
import BadgeIcon from '@mui/icons-material/Badge';
import AuthenticateUser from '../../api/auth/AuthenticateUser';
import SignButton from "../common/SignButton";

const SignUpForm = ({setMessage}) => {

    const navigate = useNavigate();

    const [userInfo, setUserInfo] = React.useState({
        name: "",
        surname: "",
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

    const signUpClicked = async (event) => {
        event.preventDefault();

        if (!validateEmail() & !validatePassword()) {
            setMessage("Email and password are incorrect!");
        }
        else if (!validateEmail()) {
            setMessage("Provided wrong email!");
        } 
        else if (!validatePassword()) {
            setMessage("Provided wrong password!");
        }
        else {
            // TODO proces rejestracji

            const res = await AuthenticateUser(userInfo);
            console.log(res.data);

            if (res.status === 200) {
                setUserInfo({
                    email: "",
                    password: ""
                })
                setMessage("");
        
                navigate("/login");
            } else {
                console.log("Error");
            }
        }
    }

    return (
        <form className="signup-form">
        <div className="input-div">
                <BadgeIcon />
                <input value={userInfo.name} onChange={changeInfo} name="name" type="text" placeholder="Name" />
            </div>
            <div className="input-div">
                <BadgeIcon />
                <input value={userInfo.surname} onChange={changeInfo} name="surname" type="text" placeholder="Surname" />
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
                Don't have an account? <span><Link to="/signup">Sign in</Link></span>
            </div>
        </form>
    )
}

export default SignUpForm;