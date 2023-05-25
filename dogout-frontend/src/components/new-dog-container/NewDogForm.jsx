import React, { useState, useEffect, useContext } from "react";
import PetsIcon from '@mui/icons-material/Pets';
import CloudUploadIcon from '@mui/icons-material/CloudUpload';
import SignButton from "../common/SignButton";
import CustomSelect from "../common/CustomSelect";
import dogService from "../../api/service/dogService";
import { WarningContext } from "../../App";

import "./NewDogForm.css";
import imageService from "../../api/service/imageService";
import userService from "../../api/service/userService";

const NewDogForm = () => {

    const [breeds, setBreeds] = useState([]);
    const [photoMessage, setPhotoMessage] = useState("Upload dog photo");
    const [uploadedImage, setUploadedImage] = useState(null);
    const { setWarning, setWarningId } = useContext(WarningContext);
    const [dogInfo, setDogInfo] = useState({
        name: '',
        age: '',
        breedId: 0,
        gender: true,
        description: ''
    })

    useEffect(() => {
        const fetchBreeds = async () => {
            try {
                const { data: response } = await dogService.getBreeds();
                setBreeds(response);
                setDogInfo(prevInfo => {
                    return {
                        ...prevInfo,
                        breedId: response[0].id
                    }
                });
            } catch (error) {
                console.error(error)
            }
        };

        fetchBreeds();
    }, []);

    const triggerWarning = (id) => {
        setWarningId(id);
        setWarning(true);
    }

    const changeInfo = (event) => {
        const { name, value } = event.target;

        setDogInfo(prevInfo => {
            return {
                ...prevInfo,
                [name]: value
            }
        });
    }

    const checkIfInputsAreEmpty = () => {
        return dogInfo.name.length === 0 ||
            dogInfo.description.length === 0 ||
            uploadedImage == null
    }

    const handlePhotoUpload = (e) => {
        e.preventDefault();
        if (e.target.files.length !== 0) {
            setUploadedImage(e.target.files[0]);
            setPhotoMessage(e.target.files[0].name);
        }
    }

    const castDogProperties = () => {
        const age = parseInt(dogInfo.age, 10);
        if (isNaN(age)) {
            triggerWarning("WRONG_AGE")
            return;
        }
        dogInfo.gender = dogInfo.gender === 'true' || dogInfo.gender === true;
        dogInfo.age = age;
        dogInfo.breedId = parseInt(dogInfo.breedId, 10);
    }

    const validateFileSize = () => {
        const MAX_FILE_SIZE = 10240;
        return uploadedImage.size / 1024 <= MAX_FILE_SIZE;
    }

    const validateName = () => {
        const pattern = /^(?=.{1,256}$)[A-ZĆŁŚŻŹa-ząćęńóśżź\\p{L}]+['-]?[A-ZĆŁŚŻŹa-ząćęńóśżź]+/;
        const matchOutput = dogInfo.name.match(pattern);
        return matchOutput != null && matchOutput[0].length === dogInfo.name.length;
    }

    const validateAge = () => {
        return dogInfo.age >= 0 && dogInfo.age <= 30;
    }

    const handleAddDogClick = async (event) => {
        event.preventDefault();

        if (checkIfInputsAreEmpty()) {
            triggerWarning("EMPTY_INPUTS");
            return;
        }

        castDogProperties();

        if (!validateFileSize()) {
            triggerWarning("WRONG_FILE_SIZE");
        }
        else if (!validateName()) {
            triggerWarning("INVALID_NAME");
        }
        else if (!validateAge()) {
            triggerWarning("AGE_RANGE");
        }
        else {
            const res = await imageService.uploadImage(uploadedImage);

            if (res.status !== 200) {
                triggerWarning("WRONG_FILE_SIZE");
            } else {
                const photoName = res.data;
                const response = await userService.addDoggy(dogInfo, photoName);

                if (response.status === 201) {
                    window.location.reload(false);
                } else {
                    triggerWarning("DOG_ADD");
                }
            }
        }
    }

    return (
        <div className="new-dog-add-page" id="my-doggy-form">
            <div className="new-dog-paw">
                <PetsIcon />
            </div>
            <h1>Adding form</h1>
            <form className="new-dog-form" encType="multipart/form-data">
                <input value={dogInfo.name} onChange={changeInfo} type="text" name="name" placeholder="Name" />
                <input value={dogInfo.age} onChange={changeInfo} type="number" name="age" placeholder="Age" />
                <CustomSelect name="breedId" onChange={changeInfo}>
                    {breeds.map(breed => <option key={breed.id} value={breed.id}>{breed.name}</option>)}
                </CustomSelect>
                <CustomSelect name="gender" onChange={changeInfo}>
                    <option value={true}>Male</option>
                    <option value={false}>Female</option>
                </CustomSelect>
                <textarea onChange={changeInfo} name="description" value={dogInfo.description} className="new-dog-textarea" cols="30" rows="10" placeholder="Description"></textarea>
                <input onChange={handlePhotoUpload} id="file-upload" accept="image/*" type="file" name="file" hidden />
                <label htmlFor="file-upload" className="dog-photo-upload">
                    <CloudUploadIcon />
                    <span id="file-chosen">{photoMessage}</span>
                </label>
                <SignButton onClick={handleAddDogClick}>Add doggy</SignButton>
            </form>
        </div>
    )
}

export default NewDogForm;