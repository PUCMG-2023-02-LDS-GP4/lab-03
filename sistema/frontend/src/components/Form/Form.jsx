import { FormGroup, FormControl, InputLabel, Input, Button, Box} from "@mui/material"
import { useState } from "react";

// const { register, handleSubmit } = useForm();
import './styles.scss'

export default function Form({fields, handleSubmit, action, buttonSubmitText, fieldsInitialValues}) {

    const [formData, setFormData] = useState(fieldsInitialValues);

    const handleChange = (event) => {
      const { name, value } = event.target;
      setFormData({ ...formData, [name]: value });
    };
  
    const handleClick = () => {
        handleSubmit();
        console.log(formData);
    }
  return (
    <div className="form-container">
    <Box action={action}>
        <FormGroup>
            {fields.map((field) => (
                <FormControl key={field.id} className="field-container">
                    <InputLabel htmlFor={field.id}>{field.label}</InputLabel>
                    <Input
                        type={field.type}
                        id={field.id}
                        name={field.id}
                        value={formData[field.id]}
                        onChange={handleChange}
                    />
                </FormControl>
            ))}
        </FormGroup>
        <Button variant='contained' onClick={handleClick} color='secondary'>{buttonSubmitText}</Button>
    </Box>
    </div>
  )
}


/*
                <TextField color='secondary' id={field.id} key={field.id} label={field.label} variant="outlined" fullWidth value={field.id} onChange={console.log("mudou")} />


                
                */