import React, { useCallback } from "react";
import DogInfoBox from "./DogInfoBox";
import DeleteIcon from '@mui/icons-material/Delete';

import "./DogInfoContainer.css";
import UserService from "../../api/service/UserService";

const DogInfoContainer = ({ doggy }) => {

    const deleteDogRequest = useCallback(async () => {
        const res = await UserService.deleteDoggy();
        const isDeleted = res.data;

        // TODO POPUP
        return !isDeleted ? console.log("Active walk") : window.location.reload(false);
    })

    return (
        <div className="my-doggy-content">
            <div className="doggy-name-container">
                <h1 id="dog-name">{doggy.name}</h1>
            </div>
            <div className="doggy-info-container">
                <div className="left-dog-info">
                    <DogInfoBox description="Size" detail={doggy.size} />
                    <DogInfoBox description="Breed" detail={doggy.breed} />
                </div>
                <div className="dog-photo-box">
                    <div style={{ "backgroundImage": `url('http://localhost:8080/api/image/${doggy.photo}')` }} className="dog-photo">
                    </div>
                </div>
                <div className="right-dog-info">
                    <DogInfoBox description="Age" detail={doggy.age} />
                    <DogInfoBox description="Gender" detail={doggy.gender} />
                </div>
            </div>
            <div className="doggy-description-container">
                <div className="description-box">
                    <div className="description-upper-box">
                        Description
                    </div>
                    <div className="description-lower-box">
                        <p>{doggy.description}</p>
                    </div>
                </div>
            </div>
            <div onClick={deleteDogRequest} className="doggy-footer-container">
                <div className="doggy-footer-remove-box">
                    <DeleteIcon />
                </div>
            </div>
        </div>
    )
}

export default DogInfoContainer;