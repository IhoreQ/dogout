import axios from "axios";

const uploadImage = async (file) => {
    const token = localStorage.getItem("token");
    const formData = new FormData();
    formData.append("image", file);

    return await axios.post(
        "/api/image",
        formData, {
        headers: {
            "Authorization": `Bearer ${token}`,
            "Access-Control-Allow-Origin": '*',
            "Content-Type": "multipart/form-data"
        },
    }
    ).then((res) => {
        if (res != null) {
            return res;
        }
    }).catch(err => {
        let error = "";
        if (err.response)
            error += err.respfonse;
        return error;
    })
}

const exportedFunctions = {
    uploadImage
}

export default exportedFunctions;