import api from "../interceptor/tokenInterceptor";

const getAllPlaces = async () => {
    try {
        return await api.get("/place/all");
    } catch (err) {
        return err;
    }
}

const getPlaceName = async (id) => {
    try {
        return await api.get(`/place/${id}`);
    } catch (err) {
        return err;
    }
    
}

const exportedFunctions = {
    getAllPlaces,
    getPlaceName
}

export default exportedFunctions;