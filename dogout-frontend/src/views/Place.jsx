import React, { useState, useEffect, useContext } from "react";
import { useParams, Link, useNavigate } from "react-router-dom";
import MainBox from "../components/common/MainBox";
import HomeIcon from '@mui/icons-material/Home';
import PlaceForm from "../components/place-form/PlaceForm";
import placeService from "../api/service/placeService";
import walkService from "../api/service/walkService";
import Warning from "../components/warning/Warning";
import { WarningContext } from "../App";

import "./Place.css";

const Place = () => {

    const { id } = useParams();
    const navigate = useNavigate();
    const { warning } = useContext(WarningContext);

    const [placeName, setPlaceName] = useState("");
    const [dogs, setDogs] = useState([]);

    useEffect(() => {
        const fetchPlaceName = async (id) => {
            try {
                const { data: response } = await placeService.getPlaceName(id);
                if (response === false) {
                    navigate("/place-not-found");
                }
                setPlaceName(response);
            } catch (error) {
                console.error(error)
            }
        };

        const fetchDogsHere = async (id) => {
            try {
                const { data: response } = await walkService.getDogs(id);
                setDogs(response);
            } catch (error) {
                console.error(error)
            }
        }

        document.title = 'Go for a walk | DogOut';
        fetchPlaceName(id);
        fetchDogsHere(id);
    }, [id]);

    return (
        <MainBox>
            {warning && <Warning />}
            <div className="place-container">
                <div className="place-header">
                    <div className="place-return-box invisible">
                    </div>
                    <div className="place-name">
                        {placeName}
                    </div>
                    <div className="place-return-box">
                        <Link to="/home">
                            <HomeIcon />
                        </Link>
                    </div>
                </div>
                <div className="place-dogs-container">
                    <div className="dog-count-header">
                        Dogs here:
                    </div>
                    <div className="dogs-here-container">
                        <div className="dogs-here-content">
                            <ul className="dog-list-header">
                                <li>Name</li>
                                <li>Breed</li>
                                <li>Size</li>
                                <li>Age</li>
                                <li>Gender</li>
                            </ul>
                            {dogs.map((dog, index) =>
                                <ul key={index} className="dog-list">
                                    <li>{dog.name}</li>
                                    <li>{dog.breed}</li>
                                    <li>{dog.size}</li>
                                    <li>{dog.age}</li>
                                    <li>{dog.gender}</li>
                                </ul>
                            )}
                        </div>
                    </div>
                </div>
                <PlaceForm placeId={id} />
            </div>
        </MainBox>
    )
}

export default Place;