import React, { useContext } from "react";
import AppCover from "../common/AppCover";
import { InformationContext } from "../../App";
import SignButton from "../common/SignButton";

import "./Information.css"

const Information = () => {

    const { setInformation, informationId } = useContext(InformationContext);

    const handleCloseClick = () => {
        setInformation(false);
    }

    const informations = new Map([
        ["DEFAULT", "Coco jumbo i do przodu - to moje motto, niezłe nie?"],
        ["PASSWORD_CHANGED", "Password changed!"]
    ]);

    return (
        <AppCover>
            <div className="warning-container">
                <div className="warning-header">
                    <div className="warning-title">
                        <h1>Information</h1>
                    </div>
                </div>
                <div className="warning-inner-container">
                    <p>{informations.get(informationId)}</p>
                    <SignButton onClick={handleCloseClick}>OK</SignButton>
                </div>
            </div>
        </AppCover>
    )
}

export default Information;