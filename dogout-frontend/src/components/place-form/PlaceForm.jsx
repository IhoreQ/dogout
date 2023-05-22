import React, { useState, useContext } from "react";
import SignButton from "../common/SignButton";
import walkService from "../../api/service/walkService";
import { useNavigate } from "react-router-dom";
import { WarningContext } from "../../App";

import "./PlaceForm.css";

const PlaceForm = ({ placeId }) => {

    const navigate = useNavigate();
    const { setWarning, setWarningId } = useContext(WarningContext);

    const [walkInfo, setWalkInfo] = useState({
        email: localStorage.getItem("email"),
        timeOfAWalk: '00:30:00',
        placeId: placeId
    })

    const triggerWarning = (id) => {
        setWarningId(id);
        setWarning(true);
    }

    const changeTimeOfAWalk = (event) => {
        const { name, value } = event.target;

        setWalkInfo(prevInfo => {
            return {
                ...prevInfo,
                [name]: value
            }
        })
    }

    const handleGoClick = async (event) => {
        event.preventDefault();

        if (!times.has(walkInfo.timeOfAWalk)) {
            triggerWarning("USER_IS_AN_IDIOT");
            return;
        }

        const res = await walkService.goForAWalk(walkInfo);

        if (res.status !== 201) {
            const message = res.data.errorMessage;
            if (message === "DOG") {
                triggerWarning("NO_DOG");
            }
            else if (message === "WALK") {
                triggerWarning("ACTIVE_WALK");
            }
        }
        else {
            navigate("/home");
        }
    }

    const times = new Map([
        ["00:30:00", "30 minutes"],
        ["00:45:00", "45 minutes"],
        ["01:00:00", "1 hour"]
    ]);

    return (
        <div className="place-form">
            <form>
                <div className="go-for-walk-box">
                    <label className="walk-time">Approximate time of a walk:</label>
                    <select onChange={changeTimeOfAWalk} name="timeOfAWalk" className="walk-select">
                        {Array.from(times).map(([key, value]) => (
                            <option key={key} value={key}>{value}</option>
                        ))}
                    </select>
                </div>
                <SignButton onClick={handleGoClick}>Go!</SignButton>
            </form>
        </div>
    )
}

export default PlaceForm;