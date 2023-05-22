import React from "react";
import MainBox from "../components/common/MainBox";
import AppWrapper from "../components/common/AppWrapper";
import Dashboard from "../components/dashboard/Dashboard";
import ContentContainer from "../components/common/ContentContainer";
import userService from "../api/service/userService";
import { useEffect, useState } from "react";
import authenticationService from "../api/service/authenticationService";
import Loading from "../components/common/Loading";

import "./Home.css";
import WalkBox from "../components/walk-box/WalkBox";

const Home = () => {

    useEffect(() => {
        document.title = 'Home | DogOut';
    }, []);

    const [activeWalk, setActiveWalk] = useState({});
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const fetchActiveWalk = async () => {
            try {
                const { data: response } = await userService.getActiveWalk();
                setActiveWalk(response);
                setLoading(false);
            } catch (error) {
                authenticationService.logout();
            }
        };

        fetchActiveWalk();
    }, []);

    return (
        <MainBox>
            <AppWrapper>
                <Dashboard activeElement="home" />
                <ContentContainer>
                    {loading && <Loading />}
                    {!loading &&
                        <div className="home-container">
                            <div className="home-content">
                                <div className="active-walk-header">
                                    {activeWalk === false ? <h1>No active walk</h1> : <h1>Active walk:</h1>}
                                </div>
                                    {activeWalk !== false && <WalkBox name={activeWalk.placeName} photo={activeWalk.photo} time={activeWalk.timeLeft}/>}
                            </div>
                        </div>}
                </ContentContainer>
            </AppWrapper>
        </MainBox>
    )
}

export default Home;