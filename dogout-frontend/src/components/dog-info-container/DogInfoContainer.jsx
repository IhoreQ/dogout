import React, { useCallback, useContext } from "react";
import DogInfoBox from "./DogInfoBox";
import DeleteIcon from '@mui/icons-material/Delete';
import UserService from "../../api/service/UserService";
import Warning from "../warning/Warning";
import AppCover from "../common/AppCover";
import { WarningContext } from "../../App";

import "./DogInfoContainer.css";

const DogInfoContainer = ({ doggy }) => {

    const { setWarning, setWarningId } = useContext(WarningContext);

    const deleteDogRequest = useCallback(async () => {
        const res = await UserService.deleteDoggy();
        const isDeleted = res.data;

        setWarningId("DOG_DELETE");
        return !isDeleted ? setWarning(true) : window.location.reload(false);
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
            <div className="doggy-footer-container">
                <div onClick={deleteDogRequest} className="doggy-footer-remove-box">
                    <DeleteIcon />
                </div>
            </div>
        </div>
    )
}

export default DogInfoContainer;