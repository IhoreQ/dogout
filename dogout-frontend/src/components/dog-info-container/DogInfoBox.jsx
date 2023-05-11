import React from "react";

import "./DogInfoBox.css";

const DogInfoBox = ({description, detail}) => {
    return (
        <div className="dog-info-box">
            <div className="upper-box">
                {description}
            </div>
            <div className="lower-box">
                <p>{detail}</p>
            </div>
        </div>
    )
}

export default DogInfoBox;