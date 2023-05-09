import React from "react";
import MainBox from "../components/common/MainBox";
import SignUpBox from "../components/signup-form/SignUpBox";

const SignUp = () => {

    React.useEffect(() => {
        document.title = 'Sign Up | DogOut';
      }, []);

    return (
        <MainBox>
            <SignUpBox></SignUpBox>
        </MainBox>
    )
}

export default SignUp;