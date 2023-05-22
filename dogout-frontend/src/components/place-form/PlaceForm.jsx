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

        const res = await walkService.goForAWalk(walkInfo);

        if (res.status !== 201) {
            const message = res.data.errorMessage;
            if (message === "DOG") {
                setWarningId("NO_DOG");
                setWarning(true);

            }
            else if (message === "WALK") {
                console.log("I co?");
                setWarningId("ACTIVE_WALK");
                setWarning(true);
            }
        }
        else {
            navigate("/home");
        }
    }

    return (
        <div className="place-form">
            <form>
                <div className="go-for-walk-box">
                    <label className="walk-time">Approximate time of a walk:</label>
                    <select onChange={changeTimeOfAWalk} name="timeOfAWalk" className="walk-select" id="">
                        <option value="00:30:00">30 minutes</option>
                        <option value="00:45:00">45 minutes</option>
                        <option value="01:00:00">1 hour</option>
                    </select>
                </div>
                <SignButton onClick={handleGoClick}>Go!</SignButton>
            </form>
        </div>
    )
}

export default PlaceForm;