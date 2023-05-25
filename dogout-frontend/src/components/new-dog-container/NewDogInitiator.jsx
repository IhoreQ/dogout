import React from "react";

import "./NewDogInitiator.css";
import SignButton from "../common/SignButton";

const NewDogInitiator = ({ setInitiatorClicked }) => {

    const handleDoItClick = () => {
        setInitiatorClicked(true);
        sessionStorage.setItem("dog-adding-initiator", true);
    }

    return (
        <div className="new-dog-info">
            <p>You have not added your doggo to the app yet.</p>
            <SignButton onClick={handleDoItClick}>Do it now!</SignButton>
        </div>
    )
}

export default NewDogInitiator;