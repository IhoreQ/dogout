import React, { useContext } from "react";
import AppCover from "../common/AppCover";
import { WarningContext } from "../../App";

import "./Warning.css";
import SignButton from "../common/SignButton";

const Warning = () => {

    const { setWarning, warningId } = useContext(WarningContext);

    const handleCloseClick = () => {
        setWarning(false);
    }

    const warnings = new Map([
        ["DEFAULT", "Something went wrong!"],
        ["DOG_DELETE", "You cannot delete your dog while you're on a walk!"],
        ["EMPTY_INPUTS", "You have to fill in all inputs!"],
        ["WRONG_AGE", "You provided age in wrong format!"],
        ["WRONG_FILE_SIZE", "The file is too big!"],
        ["INVALID_NAME", "Provided name is invalid!"],
        ["AGE_RANGE", "Age must be between 0 and 30!"]
    ]);

    return (
        <AppCover>
            <div className="warning-container">
                <div className="warning-header">
                    <div className="warning-title">
                        <h1>Warning</h1>
                    </div>
                </div>
                <div className="warning-inner-container">
                    <p>{warnings.get(warningId)}</p>
                    <SignButton onClick={handleCloseClick}>OK</SignButton>
                </div>
            </div>
        </AppCover>
    )
}

export default Warning;