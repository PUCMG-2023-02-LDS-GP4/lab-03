import { useState } from "react";
import axios from "axios";
import {
	FormGroup,
	FormControl,
	InputLabel,
	Input,
	Button,
	Box,
	styled,
} from "@mui/material";
import { useForm } from "react-hook-form";
import CloudUploadIcon from "@mui/icons-material/CloudUpload";

export default function CreateVantagemModal() {

	const { register, handleSubmit } = useForm();
	const [cloathImage, setImage] = useState("");
    const [showImg, setShowImg] = useState();

	const handleClick = (e) => {
		submit(e);
	};

	function submit({ descricao, custo, quantidade, foto }) {
		// TODO fazer requisição post
		var bodyFormData = new FormData();
		bodyFormData.append("descricao", descricao);
		bodyFormData.append("custo", custo);
		bodyFormData.append("quantidade", quantidade);
		bodyFormData.append("foto", foto[0] || "");
		console.log(
			"descricao: ",
			descricao,
			"custo:",
			custo,
			"quantidade:",
			quantidade,
			"foto:",
			foto
		);
		try {
			axios
				.post(
					"http://localhost:8080/alunos",
					{
						descricao: descricao,
						custo: custo,
						quantidade: quantidade,
						foto: foto,
					},
					{
						headers: { "Content-Type": "application/json" },
					}
				)
				.then((res) => {
					if (res.status === 200) {
						alert("Aluno criado!");
					} else {
						alert("Usuário ou Senha incorretos!");
					}
				});
		} catch (error) {
			console.error(error.response.data);
		}
	}

	const labels = [
		{ id: "descricao", label: "Descrição", type: "text" },
		{ id: "custo", label: "Custo", type: "text" },
		{ id: "quantidade", label: "Quantidade", type: "text" },
	];

    const handleOpenImg = () => {

    }

	const handleImageChange = (e) => {
		const file = e.target.files[0];
		setImage(file);
		setShowImg(file);
		handleOpenImg();
	};

	const VisuallyHiddenInput = styled("input")({
		clip: "rect(0 0 0 0)",
		clipPath: "inset(50%)",
		height: 1,
		overflow: "hidden",
		position: "absolute",
		bottom: 0,
		left: 0,
		whiteSpace: "nowrap",
		width: 1,
	});
	const ButtonStyle = {
		variant: "contained",
		disableRipple: true,
		size: "large",
		fullWidth: true,
	};
	return (
		<>
			<div className='form-container'>
				<Box>
					<FormGroup>
						{labels.map((field) => (
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
						<Button
							{...ButtonStyle}
							component='label'
							onChange={handleImageChange}
							startIcon={<CloudUploadIcon />}
						>
							{cloathImage.name ? "Alterar Foto" : "Adicione uma Foto"}
							<VisuallyHiddenInput
								type='file'
								name='imagem'
								accept='image/*'
								{...register("imagem")}
							/>
						</Button>
					</FormGroup>
					<Button
						{...ButtonStyle}
						variant='contained'
						onClick={handleSubmit(handleClick)}
						color='secondary'
					>
						Criar Vantagem
					</Button>
				</Box>
			</div>
		</>
	);
}