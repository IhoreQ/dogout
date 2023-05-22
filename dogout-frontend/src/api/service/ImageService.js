import api from "../interceptor/imageInterceptor";

const uploadImage = async (file) => {
    const formData = new FormData();
    formData.append("image", file);

    try {
        return await api.post('/image', formData);
    } catch (err) {
        return err;
    }
}

const exportedFunctions = {
    uploadImage
}

export default exportedFunctions;