import React, { useEffect } from "react";
import { useState } from "react";
import userService from "../../api/service/userService";

import "./WalkBox.css";

const WalkBox = ({ name, time, photo }) => {

    const [timeLeft, setTimeLeft] = useState(time);

    const handleFinishClick = () => {
        userService.finishWalk();
        window.location.reload(false);
    }

    const decrementSeconds = (timeLeft) => {
        let hours = parseInt(timeLeft.substring(0, 2));
        let minutes = parseInt(timeLeft.substring(3, 5));
        let seconds = parseInt(timeLeft.substring(6, 8));

        if (hours === 1) {
            minutes = 59;
            seconds = 59;
        }

        seconds--;

        if (minutes === 0 && seconds === 0) {
            handleFinishClick();
        }

        if (seconds < 0) {
            minutes--;
            seconds = 59;
        }

        if (minutes < 10)
            minutes = "0" + minutes;
        if (seconds < 10)
            seconds = "0" + seconds;

        setTimeLeft(`00:${minutes}:${seconds}`);
    }

    useEffect(() => {
        const interval = setInterval(() => {
          decrementSeconds(timeLeft);
        }, 1000);
    
        return () => clearInterval(interval);
      }, [timeLeft]);

    return (
        <div style={{ "backgroundImage": `url('/img/places/${photo}')` }} className="active-walk-box">
            <div className="active-walk-box-header">
                <p className="invisible active-walk-symmetric-p">Ends in: <span className="active-walk-left-time">00:00</span></p>
                <h1 className="active-walk-name">{name}</h1>
                <p className="active-walk-p">Ends in: <span className="active-walk-left-time">{timeLeft}</span></p>
            </div>
            <div onClick={handleFinishClick} className="active-walk-finish">
                <h1>Finish</h1>
            </div>
        </div>
    )
}

export default WalkBox;