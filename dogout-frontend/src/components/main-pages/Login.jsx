import React from "react";
import MainBox from "./MainBox";
import LoginBox from "../login/LoginBox";

const Login = () => {

    React.useEffect(() => {
        document.title = 'Login | DogOut';
      }, []);

    return (
        <MainBox>
            <LoginBox />
        </MainBox>
    )
}

export default Login;