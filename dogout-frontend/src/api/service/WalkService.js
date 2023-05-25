import api from "../interceptor/tokenInterceptor";

const getDogs = async (id) => {
    try {
        return await api.get(`/walk/${id}`);
    } catch (err) {
        return err;
    }
}

const goForAWalk = async (walkInfo) => {
    try {
        return await api.post("/walk", walkInfo);
    } catch (err) {
        return err;
    }
}

const exportedFunctions = {
    getDogs,
    goForAWalk
}

export default exportedFunctions;