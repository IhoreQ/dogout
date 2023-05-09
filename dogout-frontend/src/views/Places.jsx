import React from "react";
import MainBox from "../components/common/MainBox";
import AppWrapper from "../components/common/AppWrapper";
import Dashboard from "../components/dashboard/Dashboard";
import ContentContainer from "../components/common/ContentContainer";
import PlaceService from "../api/service/PlaceService";
import { useState, useEffect } from "react";
import { Link } from "react-router-dom";

const Places = () => {

    useEffect(() => {
        document.title = 'Places | DogOut';
      }, []);

    const [places, setPlaces] = useState([]);

    useEffect(() => {
        const fetchPlaces = async () => {
          try {
            const { data: response } = await PlaceService.getAllPlaces();
            setPlaces(response);
          } catch (error) {
            console.error(error)
          }
        };
    
        fetchPlaces();
      }, []);

    return (
        <MainBox>
            <AppWrapper>
                <Dashboard activeElement="places"/>
                <ContentContainer>
                    {places.map(place => (<Link to={`/place/${place.idPlace}`} key={place.idPlace}>{place.name}</Link>))}
                </ContentContainer>
            </AppWrapper>
        </MainBox>
    )
}

export default Places;