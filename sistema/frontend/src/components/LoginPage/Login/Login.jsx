import React, { useState } from "react";
import Input from "../Input";
import { Link, useNavigate } from "react-router-dom";
import Button from "../Button";
import * as C from "./styles";
import axios from "axios";

export default function Login() {
	const navigate = useNavigate();

	const [email, setEmail] = useState("");
	const [senha, setSenha] = useState("");
	const [error, setError] = useState("");

	function handleLogin(event) {
		event.preventDefault();
		if (!email || !senha) {
			setError("Preencha todos os campos");
			return;
		}

		axios
			.post("http://localhost:8080/user/authenticate", {
				email: email,
				password: senha,
			})
			.then((res) => {
				if (res.status === 200) {
					navigate("/home");
				} else {
					alert("Usuário ou Senha incorretos!");
				}
			});
	}

	return (
		<C.Container>
			<C.Label>LOGIN</C.Label>
			<C.Content>
				<Input
					type='email'
					placeholder='Digite seu E-mail'
					value={email}
					onChange={(e) => [setEmail(e.target.value), setError("")]}
				/>
				<Input
					type='password'
					placeholder='Digite sua Senha'
					value={senha}
					onChange={(e) => [setSenha(e.target.value), setError("")]}
				/>
				<C.labelError>{error}</C.labelError>
				<Button Text='Entrar' onClick={handleLogin} />
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
