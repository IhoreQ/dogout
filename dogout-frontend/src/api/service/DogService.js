import api from '../interceptor/tokenInterceptor';

const getBreeds = async () => {
    try {
        return await api.get('/dog/breeds');
    } catch (err) {
        return err;
    }
}

const exportedFunctions = {
    getBreeds
}

export default exportedFunctions;