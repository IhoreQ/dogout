import React from "react";
import MainBox from "../components/common/MainBox";
import AppWrapper from "../components/common/AppWrapper";
import Dashboard from "../components/dashboard/Dashboard";
import ContentContainer from "../components/common/ContentContainer";
import PlaceService from "../api/service/PlaceService";
import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import PlaceBox from "../components/common/PlaceBox";
import Loading from "../components/common/Loading";

import "./Places.css";


const Places = () => {

  const [loading, setLoading] = useState(true);

  useEffect(() => {
    document.title = 'Places | DogOut';
  }, []);

  const [places, setPlaces] = useState([]);

  useEffect(() => {
    const fetchPlaces = async () => {
      try {
        const { data: response } = await PlaceService.getAllPlaces();
        setPlaces(response);
        setLoading(false);
      } catch (error) {
        console.error(error)
      }
    };

    fetchPlaces();
  }, []);

  return (
    <MainBox>
      <AppWrapper>
        <Dashboard activeElement="places" />
        <ContentContainer>
          {loading && <Loading />}
          {!loading &&
            <div className="places-container">
              <div className="places-content">
                {places.map(place => (<PlaceBox key={place.idPlace} name={place.name} idPlace={place.idPlace} photo={place.photo} />))}
                <div className="places-footer-ideas">
                  <span>Send your ideas about places here!</span>
                </div>
              </div>
            </div>
          }
        </ContentContainer>
      </AppWrapper>
    </MainBox>
  )
}

export default Places;