import {
	FormGroup,
	FormControl,
	InputLabel,
	Input,
	Button,
	Box,
} from "@mui/material";
import { useForm } from "react-hook-form";

import "./styles.scss";

export default function Form({
	fields,
	action,
	submit,
	buttonSubmitText,
	buttonColor
}) {
	// const handleChange = (event) => {
	// 	const { name, value } = event.target;
	// 	setFormData({ ...formData, [name]: value });
	// };

	const { register, handleSubmit } = useForm();

	const handleClick = (e) => {
		submit(e);
	};
	return (
		<div className='form-container'>
			<Box action={action || ""} sx={{display: "grid", justifyContent: "center", alignItems: "center"}}>
				<FormGroup>
					{fields.map((field) => (
						<FormControl key={field.id} className='field-container'>
							<InputLabel htmlFor={field.id}>{field.label}</InputLabel>
							<Input
								type={field.type}
								id={field.id}
								name={field.id}
								{...register(field.id)}
							/>
						</FormControl>
					))}
				</FormGroup>
				<Button
					variant='contained'
					onClick={handleSubmit(handleClick)}
					color={buttonColor || "secondary"}
				>
					{buttonSubmitText}
				</Button>
			</Box>
		</div>
	);
}
