import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import * as C from "./styles";
import axios from "axios";
import { useForm } from "react-hook-form";

export default function Login() {
	const navigate = useNavigate();

	const [error, setError] = useState("");
	const { register, handleSubmit } = useForm();

	function onSubmit({ email, password }) {
		console.log(email, password);
		if (!email || !password) {
			setError("Preencha todos os campos");
			return;
		}

		try {
			axios
				.post(
					"http://localhost:8080/users/authenticate",
					{
						email: email,
						password: password,
					},
					{
						headers: { "Content-Type": "application/json" },
					}
				)
				.then((res) => {
					if (res.status === 200) {
						navigate("/home");
					} else {
						alert("Usuário ou Senha incorretos!");
					}
				});
		} catch (error) {
			console.error(error.response.data);
		}
	}

	return (
		<C.Container>
			<C.Label>LOGIN</C.Label>
			<C.Content onSubmit={handleSubmit(onSubmit)}>
				<C.Input
					type='email'
					placeholder='Digite seu E-mail'
					{...register("email", { required: true })}
				/>
				<C.Input
					type='password'
					placeholder='Digite sua Senha'
					{...register("password", { required: true })}
				/>
				<C.labelError>{error}</C.labelError>
				<C.Input type={"submit"} />
				<C.LabelSignup>
					Não tem uma conta?
					<C.Strong>
						<Link to='/cadastro'>Registre-se</Link>
					</C.Strong>
				</C.LabelSignup>
			</C.Content>
		</C.Container>
	);
}
