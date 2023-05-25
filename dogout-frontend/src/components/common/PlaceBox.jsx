import React from "react";
import { Link, useNavigate } from "react-router-dom";

import "./PlaceBox.css";

const PlaceBox = ({ idPlace, name, photo }) => {

    let navigate = useNavigate();
    let photoName = photo.substring(0, photo.indexOf('.'));

    const handlePhotoClick = () => {
        navigate(`/place/${idPlace}`);
    }

    return (
        <div onClick={handlePhotoClick} className="place-box" id={photoName}>
            <Link to={`/place/${idPlace}`} className="place-text-box">
                {name}
            </Link>
        </div>
    )
}

export default PlaceBox;