import React from "react";
import MainBox from "../components/common/MainBox";
import AppWrapper from "../components/common/AppWrapper";
import Dashboard from "../components/dashboard/Dashboard";
import { useState, useEffect, useContext } from "react";
import userService from "../api/service/userService";
import ContentContainer from "../components/common/ContentContainer";
import Loading from "../components/common/Loading";
import DogInfoContainer from "../components/dog-info-container/DogInfoContainer";
import { WarningContext } from "../App";
import Warning from "../components/warning/Warning";

import "./MyDoggy.css";
import NewDogContainer from "../components/new-dog-container/NewDogContainer";

const MyDoggy = () => {

    const [doggy, setDoggy] = useState(null);
    const [loading, setLoading] = useState(true);
    const { warning } = useContext(WarningContext);

    useEffect(() => {
        const fetchDoggy = async () => {
            try {
                const response = await userService.getDoggy();
                if (response.status === 200) {
                    setDoggy(response.data);
                    setLoading(false);
                }
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
                {warning && <Warning />}
                <Dashboard activeElement="my-doggy" />
                <ContentContainer>
                    {loading && <Loading />}
                    {!loading &&
                        <div className="my-doggy-container">
                            {doggy ?
                                <DogInfoContainer doggy={doggy} />
                                :
                                <NewDogContainer />
                            }
                        </div>
                    }

                </ContentContainer>
            </AppWrapper>
        </MainBox>
    )
}

export default MyDoggy;