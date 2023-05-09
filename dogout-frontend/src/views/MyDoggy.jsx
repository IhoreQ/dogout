import React from "react";
import MainBox from "../components/common/MainBox";
import AppWrapper from "../components/common/AppWrapper";
import Dashboard from "../components/dashboard/Dashboard";
import { useState, useEffect } from "react";
import UserService from "../api/service/UserService";
import ContentContainer from "../components/common/ContentContainer";

const MyDoggy = () => {

    const [doggy, setDoggy] = useState({});

    useEffect(() => {
        const fetchDoggy = async () => {
            try {
                const { data: response } = await UserService.getDoggy();
                setDoggy(response);
            } catch (error) {
                console.error(error)
            }
        };

        document.title = 'My doggy | DogOut';
        fetchDoggy();
    }, []);

    console.log(doggy);

    return (
        <MainBox>
            <AppWrapper>
                <Dashboard activeElement="my-doggy" />
                <ContentContainer>
                    {doggy === false ? "nodoggo" : "doggo"}
                </ContentContainer>
            </AppWrapper>
        </MainBox>
    )
}

export default MyDoggy;