import axios from "axios";

const uploadImage = async (file) => {
    return axios.post(
        "/api/image", {
        body:  {
            "image": file,
        },
        headers: {
            "Authorization": `Bearer ${token}`,
            "Access-Control-Allow-Origin": '*',
            'Content-Type': file.type,
            'Content-Length': `${file.size}`
        },
    }
    ).then((res) => {
        if (res != null) {
            return res;
        }
    })
        .catch(err => {
            let error = "";
            if (err.response)
                error += err.respfonse;
            return error;
        })
}

export default {
    uploadImage
}