import React from "react";
import MainBox from "../components/common/MainBox";
import LoginBox from "../components/login-form/LoginBox";

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