import React from "react";
import MainBox from "../components/common/MainBox";
import AppWrapper from "../components/common/AppWrapper";
import Dashboard from "../components/dashboard/Dashboard";
import ContentContainer from "../components/common/ContentContainer";
import UserService from "../api/service/UserService";
import { useEffect, useState } from "react";

const Home = () => {

    useEffect(() => {
        document.title = 'Home | DogOut';
    }, []);

    const [activeWalk, setActiveWalk] = useState({});

    useEffect(() => {
        const fetchActiveWalk = async () => {
            try {
                const { data: response } = await UserService.getActiveWalk();
                setActiveWalk(response);
            } catch (error) {
                console.error(error) 
            }
        };

        fetchActiveWalk();
    }, []);

    return (
        <MainBox>
            <AppWrapper>
                <Dashboard activeElement="home" />
                <ContentContainer>
                    {activeWalk === false ? "No active walk!" : activeWalk.placeName}
                </ContentContainer>
            </AppWrapper>
        </MainBox>
    )
}

export default Home;