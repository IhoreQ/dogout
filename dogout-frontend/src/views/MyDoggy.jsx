import React from "react";
import MainBox from "../components/common/MainBox";
import AppWrapper from "../components/common/AppWrapper";
import Dashboard from "../components/dashboard/Dashboard";
import { useState, useEffect } from "react";
import UserService from "../api/service/UserService";
import ContentContainer from "../components/common/ContentContainer";
import Loading from "../components/common/Loading";
import DogInfoContainer from "../components/dog-info-container/DogInfoContainer";

import "./MyDoggy.css";

const MyDoggy = () => {

    const [doggy, setDoggy] = useState({});
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const fetchDoggy = async () => {
            try {
                const { data: response } = await UserService.getDoggy();
                setDoggy(response);
                setLoading(false);
            } catch (error) {
                console.error(error)
            }
        };

        document.title = 'My doggy | DogOut';
        fetchDoggy();
    }, []);

    return (
        <MainBox>
            <AppWrapper>
                <Dashboard activeElement="my-doggy" />
                <ContentContainer>
                    {loading && <Loading />}
                    <div className="my-doggy-container">
                        {!loading && doggy &&
                        <DogInfoContainer doggy={doggy} />
                        }
                    </div>
                </ContentContainer>
            </AppWrapper>
        </MainBox>
    )
}

export default MyDoggy;