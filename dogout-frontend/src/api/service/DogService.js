import api from '../interceptor/tokenInterceptor';

const getBreeds = async () => {
    try {
        const res = await api.get('/dog/breeds');
        return res;
    } catch (err) {
        return err;
    }
}

const exportedFunctions = {
    getBreeds
}

export default exportedFunctions;