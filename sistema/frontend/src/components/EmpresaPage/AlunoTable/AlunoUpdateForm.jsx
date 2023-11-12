import Form from "../../Form/Form";

export default function AlunoUpdateForm({ alunoToUpdate }) {
	const labels = [
		{ id: "email", label: "E-mail", type: "text" },
		{ id: "nome", label: "Nome", type: "text" },
		{ id: "password", label: "Senha", type: "password" },
		{ id: "cpf", label: "CPF", type: "text" },
		{ id: "endereco", label: "Endereço", type: "text" },
		{ id: "Instituicao", label: "Instuição", type: "text" },
		{ id: "curso", label: "Curso", type: "text" },
	];

	const initialValues = {
		descricao: "",
		custo: "",
		quantidade: "",
		foto: "",
	};

	function getAlunoId(alunoId) {
		console.log(alunoId);
	}

	function handleSubmit(aluno) {
		// TODO metódo update
		getAlunoId(aluno);
		alert(`Aluno ${aluno} atualizado.`);
	}

	return (
		<>
			<Form
				fields={labels}
				handleSubmit={() => handleSubmit(alunoToUpdate)}
				action={"/alunos"}
				buttonSubmitText='Atualizar'
				fieldsInitialValues={initialValues}
			/>
		</>
	);
}
