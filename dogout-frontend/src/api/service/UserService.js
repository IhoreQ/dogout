import api from "../interceptor/tokenInterceptor";

const getActiveWalk = async () => {
    try {
        return await api.get('/walk');
    } catch (err) {
        return err;
    }
}

const finishWalk = async () => {
    try {
        return await api.delete('/walk');
    } catch (err) {
        return err;
    }
}

const getDoggy = async () => {
    try {
        return await api.get('/dog');
    } catch (err) {
        return err;
    }
}

const deleteDoggy = async () => {
    try {
        return await api.delete('/dog');
    } catch (err) {
        return err;
    }
}

const addDoggy = async (doggy, photoName) => {
    try {
        return await api.post('/dog', doggy, {
            params: {
                "photo": photoName
            }
        });
    } catch (err) {
        return err;
    }
}

const changePassword = async (passwords) => {
    try {
        return await api.patch('/user/password', passwords);
    } catch (err) {
        return err;
    }
}

const exportedFunctions = {
    getActiveWalk,
    getDoggy,
    finishWalk,
    deleteDoggy,
    addDoggy,
    changePassword
};

export default exportedFunctions;