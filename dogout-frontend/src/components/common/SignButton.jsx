import React from "react";
import "./SignButton.css"

const SignButton = ({onClick, children}) => {
    return <button onClick={onClick} className="sign-button">{children}</button>
}

export default SignButton;