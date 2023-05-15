import React, { useState, useEffect } from "react";
import PetsIcon from '@mui/icons-material/Pets';
import CloudUploadIcon from '@mui/icons-material/CloudUpload';

import "./NewDogForm.css";
import SignButton from "../common/SignButton";
import CustomSelect from "../common/CustomSelect";
import DogService from "../../api/service/DogService";

const NewDogForm = () => {

    const [breeds, setBreeds] = useState([]);
    const [photoMessage, setPhotoMessage] = useState("Upload dog photo");
    const [uploadedImage, setUploadedImage] = useState(null);
    const [loading, setLoading] = useState(true);
    const [dogInfo, setDogInfo] = useState({
        name: '',
        age: '',
        breedId: 0,
        gender: true,
        description: '',
        photo: uploadedImage
    })

    const changeInfo = (event) => {
        const { name, value } = event.target;

        setDogInfo(prevInfo => {
            return {
                ...prevInfo,
                [name]: value
            }            
        });
    }

    const handlePhotoUpload = (e) => {
        e.preventDefault();
        setUploadedImage(e.target.files[0]);
        setPhotoMessage(e.target.files[0].name);
    }

    useEffect(() => {
        const fetchBreeds = async () => {
            try {
                const { data: response } = await DogService.getBreeds();
                setBreeds(response);
                setDogInfo(prevInfo => {
                    return {
                        ...prevInfo,
                        breedId: response[0].id
                    }            
                });
                setLoading(false);
            } catch (error) {
                console.error(error)
            }
        };

        fetchBreeds();
    }, []);

    const validateFileSize = () => {
        const MAX_FILE_SIZE = 10240;

        if (uploadedImage == null)
            return false;

        console.log(uploadedImage);
        
        return uploadedImage.size / 1024 <= MAX_FILE_SIZE;
    }

    const validateName = () => {
        const pattern = /^(?=.{1,256}$)[A-ZĆŁŚŻŹa-ząćęńóśżź\\p{L}]+['-]?[A-ZĆŁŚŻŹa-ząćęńóśżź]+/;
        return dogInfo.name.match(pattern);
    }

    const handleAddDogClick = (event) => {
        event.preventDefault();
        
        // if (!validateFileSize()) {
            
        // } 
        // else if (!validateName()) {

        // }
        // else {

        // }
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
                <textarea name="new-dog-description" className="new-dog-textarea" cols="30" rows="10" placeholder="Description" required></textarea>
                <input onChange={handlePhotoUpload} id="file-upload" accept="image/*" type="file" name="file" hidden required />
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