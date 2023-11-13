import React, { useState } from "react";
import { useForm } from "react-hook-form";
import * as Styles from "./styles";
import { Link, useNavigate } from "react-router-dom";
import axios from "axios";
import { FormControl, InputLabel, MenuItem, Select } from "@mui/material";

const CadastroAluno = () => {
	const [error, setError] = useState("");
	const { register, handleSubmit } = useForm();

	const navigate = useNavigate();

	const onSubmit = ({
		nome,
		email,
		emailConf,
		password,
		cpf,
		rg,
		endereco,
		instituicao,
		curso,
	}) => {
		if (!email | !emailConf | !password) {
			setError("Preencha todos os campos");
			return;
		} else if (email !== emailConf) {
			setError("Os e-mails não são iguais");
			return;
		} else if (password.length < 9) {
			setError("A senha deve conter no mínimo 9 caracteres");
			return;
		}
		const tipoUser = "ALUNO";
		try {
			axios
				.post(
					"//localhost:8080/alunos",
					{
						nome: nome,
						email: email,
						password: password,
						cpf: cpf,
						rg: rg,
						endereco: endereco,
						instituicao: instituicao,
						curso: curso,
						tipoUser: tipoUser,
					},
					{
						headers: { "Content-Type": "application/json" },
					}
				)
				.then((res) => {
					if (res.status === 200) {
						alert("Aluno cadatrado com sucesso!");
						navigate("/");
					} else {
						alert("Não foi possivel realizar o cadastro, tente novamente!");
					}
				})
				.catch((error) => {
					console.log(error.response.data);
					console.log(nome);
				});
		} catch (error) {
			console.error(error.response.data);
		}
	};

	return (
		<Styles.Container>
			<Styles.Label>Cadastre sua Empresa</Styles.Label>
			<Styles.Content onSubmit={handleSubmit(onSubmit)}>
				<Styles.Input
					type='text'
					placeholder={"Digite seu Nome"}
					{...register("nome", { required: true })}
				/>
				<Styles.Input
					type='email'
					placeholder='Digite seu E-mail'
					{...register("email", { required: true })}
				/>
				<Styles.Input
					type='email'
					placeholder='Confirme seu E-mail'
					{...register("emailConf", { required: true })}
				/>
				<Styles.Input
					type='password'
					placeholder='Digite sua Senha'
					{...register("password", { required: true })}
				/>
				<Styles.Input
					type='text'
					placeholder={"Digite seu CPF"}
					{...register("cpf", { required: true })}
				/>
				<Styles.Input
					type='text'
					placeholder='Digite seu RG'
					{...register("rg", { required: true })}
				/>
				<Styles.Input
					type='text'
					placeholder='Confirme seu Endereço'
					{...register("endereco", { required: true })}
				/>
				<FormControl sx={{ width: "100%" }}>
					<InputLabel size='small'>Instituição</InputLabel>
					<Select
						size='small'
						defaultValue={0}
						{...register("instituicao", {
							required: "Instituicao é obrigatória",
						})}
						autoWidth
						label='Instituição'
					>
						<MenuItem divider={true} sx={{ width: 300 }} value={0}>
							<em>- -</em>
						</MenuItem>
						<MenuItem divider={true} sx={{ width: 300 }} value={"PUC"}>
							PUC
						</MenuItem>
						<MenuItem divider={true} sx={{ width: 300 }} value={"UFMG"}>
							UFMG
						</MenuItem>
						<MenuItem divider={true} sx={{ width: 300 }} value={"UEMG"}>
							UEMG
						</MenuItem>
						<MenuItem divider={true} sx={{ width: 300 }} value={"CEFET"}>
							CEFET
						</MenuItem>
					</Select>
				</FormControl>
				<FormControl sx={{ width: "100%" }}>
					<InputLabel size='small'>Curso</InputLabel>
					<Select
						size='small'
						defaultValue={0}
						{...register("curso", {
							required: "Curso é obrigatória",
						})}
						autoWidth
						label='Curso'
					>
						<MenuItem divider={true} sx={{ width: 300 }} value={0}>
							<em>- -</em>
						</MenuItem>
						<MenuItem divider={true} sx={{ width: 300 }} value={"MATEMATICA"}>
							Matematica
						</MenuItem>
						<MenuItem divider={true} sx={{ width: 300 }} value={"MEDICINA"}>
							Medicina
						</MenuItem>
						<MenuItem divider={true} sx={{ width: 300 }} value={"DIREITO"}>
							Direito
						</MenuItem>
						<MenuItem divider={true} sx={{ width: 300 }} value={"BIOLOGIA"}>
							Biologia
						</MenuItem>
						<MenuItem divider={true} sx={{ width: 300 }} value={"SOCIOLOGIA"}>
							Sociologia
						</MenuItem>
					</Select>
				</FormControl>
				<Styles.labelError>{error}</Styles.labelError>
				<Styles.Input type={"submit"} />
				<Styles.LabelSignin>
					Já tem uma conta?
					<Styles.Strong>
						<Link to='/'>Entre</Link>
					</Styles.Strong>
				</Styles.LabelSignin>
			</Styles.Content>
		</Styles.Container>
	);
};

export default CadastroAluno;
