import { useState } from "react";
import Form from "../../Form/Form";
import axios from "axios";

export default function AlunoForm() {
	const initialValues = {
		email: "",
		nome: "",
		password: "",
		cpf: "",
		endereco: "",
		Instituicao: "",
		curso: "",
	};

	//const [formData, setFormData] = useState(initialValues);

	//const body = JSON.stringify(formData);

	function submit({
		email,
		nome,
		password,
		cpf,
		endereco,
		Instituicao,
		curso,
	}) {
		// TODO fazer requisição post

		console.log(
			"email: ",
			email,
			"nome:",
			nome,
			"password:",
			password,
			"cpf:",
			cpf,
			"endereco:",
			endereco,
			"inst:",
			Instituicao,
			"curso:",
			curso
		);

		try {
			axios
				.post(
					"http://localhost:8080/alunos",
					{
						email: email,
						nome: nome,
						password: password,
						cpf: cpf,
						endereco: endereco,
						Instituicao: Instituicao,
						curso: curso,
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
		{ id: "email", label: "E-mail", type: "text" },
		{ id: "nome", label: "Nome", type: "text" },
		{ id: "password", label: "Senha", type: "password" },
		{ id: "cpf", label: "CPF", type: "text" },
		{ id: "endereco", label: "Endereço", type: "text" },
		{ id: "Instituicao", label: "Instuição", type: "text" },
		{ id: "curso", label: "Curso", type: "text" },
	];

	return (
		<>
			<Form
				fields={labels}
				submit={submit}
				action={"/alunos"}
				buttonSubmitText='Novo Aluno'
				fieldsInitialValues={initialValues}
			/>
		</>
	);
}
