import React, { useState } from "react";
// Importando o useForm para fazer a validação dos campos de formulário
import { useForm } from "react-hook-form";
// Importando os estilos do arquivo Styles.js
import * as Styles from "./styles";
// Importando o Link e useNavigate para fazer a navegação entre as páginas sem recarregar ela
import { Link, useNavigate } from "react-router-dom";
// Import axios para conectar com o backend
import axios from "axios";
import { FormControl, InputLabel, MenuItem, Select } from "@mui/material";

const CadastroEmpresa = () => {
	// state de error que quando for alterado, vai mudar o componente que ele está, no caso o da linha 84
	// quando você quer dar um valor à error, você utiliza o setError, e quando você quer pegar o valor de error, você utiliza o error
	const [error, setError] = useState("");
	// Desestruturando o useForm para pegar os métodos que precisaremos utilizar, isso é melhor olhar na documentação dele, mas qualquer coisa eu explico
	const { register, handleSubmit } = useForm();

	// Desestruturando o useNavigate para poder fazer a navegação entre as páginas
	const navigate = useNavigate();

	// Função que vai ser chamada quando o usuário clicar no botão de submit
	const onSubmit = ({ nome, email, emailConf, password }) => {
		// Verificando as regras de email == emailConf e se a senha tem mais de 9 caracteres
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
		const tipoUser = "EMPRESA";
		// Fazendo a requisição para o backend, eu acho que da pra otimizar isso aqui.
		try {
			axios
				.post(
					"//localhost:8080/empresas",
					{ nome: nome, email: email, password: password, tipoUser: tipoUser },
					{
						headers: { "Content-Type": "application/json" },
					}
				)
				.then((res) => {
					if (res.status === 200) {
						alert("Usuário cadatrado com sucesso!");
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

	// Todo componente que tem Styles. é um componente de StyledComponents, que é uma biblioteca que permite criar componentes estilizados com CSS
	return (
		<Styles.Container>
			<Styles.Label>Cadastre sua Empresa</Styles.Label>
			<Styles.Content onSubmit={handleSubmit(onSubmit)}>
				<Styles.Input
					type='text'
					placeholder={"Digite o nome da sua empresa"}
					{...register("nome", { required: true })}
				/>
				<Styles.Input
					type='email'
					placeholder='Digite o E-mail'
					{...register("email", { required: true })}
				/>
				<Styles.Input
					type='email'
					placeholder='Confirme o E-mail'
					{...register("emailConf", { required: true })}
				/>
				<Styles.Input
					type='password'
					placeholder='Digite sua Senha'
					{...register("password", { required: true })}
				/>
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

export default CadastroEmpresa;
