import { useEffect, useState } from "react";
import Table from "../../Table/Table";
import { TableRow, TableCell, Button } from "@mui/material";
import CustomModal from "../../CustomModal/CustomModal";
import AlunoCreateForm from "./AlunoCreateForm";
import AlunoUpdateForm from "./AlunoUpdateForm";

export default function AlunoTable() {
	const [students, setStudents] = useState([
		{
			id: "123",
			nome: "teste teste teste",
			email: "teste@teste",
			saldoDeMoedas: 0,
			curso: "a",
			instituicao: "a",
		},
	]);

	useEffect(() => {
		fetch("http://localhost:8080/alunos")
			.then((res) => res.json())
			.then((res) => setStudents(res));
	}, []);
	const [showCreateModal, setShowCreateModal] = useState(false);
	const [showUpdateModal, setShowUpdateModal] = useState(false);
	const [alunoUpdateId, setAlunoUpdateId] = useState();

	const columns = [
		{ id: "id", label: "Id", minWidth: 50 },
		{ id: "name", label: "Nome", minWidth: 50 },
		{ id: "mail", label: "Email", minWidth: 50 },
		{ id: "course", label: "Curso", minWidth: 50 },
		{ id: "institution", label: "Instituição", minWidth: 50 },
		{ id: "cash", label: "Saldo de Moedas", minWidth: 20 },
		{ id: "actionButtons", label: "Ações", minWidth: 50 },
	];

	function handleCreate() {
		setShowCreateModal(true);
	}

	function handleCloseCreateModal() {
		setShowCreateModal(false);
	}

	function handleUpdate(alunoId) {
		setShowUpdateModal(true);
		setAlunoUpdateId(alunoId);
	}

	function handleCloseUpdateModal() {
		setShowUpdateModal(false);
	}

	function handleDelete(alunoId) {
		alert(`Aluno ${alunoId} foi deletado`);
	}

	return (
		<>
			<Button variant='outlined' onClick={handleCreate}>
				Novo Aluno
			</Button>

			<Table columns={columns}>
				{students.map((student) => (
					<TableRow key={student.id}>
						<TableCell>{student.id}</TableCell>
						<TableCell>{student.nome}</TableCell>
						<TableCell>{student.email}</TableCell>
						<TableCell>{student.curso}</TableCell>
						<TableCell>{student.instituicao}</TableCell>
						<TableCell>{student.saldoDeMoedas}</TableCell>
						<TableCell className='action-buttons'>
							<Button
								variant='outlined'
								onClick={() => handleUpdate(student.id)}
							>
								Atualizar
							</Button>
							<Button
								variant='outlined'
								onClick={() => handleDelete(student.id)}
								color='error'
							>
								Deletar
							</Button>
						</TableCell>
					</TableRow>
				))}
			</Table>

			<CustomModal
				isOpen={showCreateModal}
				handleCloseCreateModal={handleCloseCreateModal}
				onClose={handleCloseCreateModal}
			>
				<AlunoCreateForm />
			</CustomModal>

			<CustomModal isOpen={showUpdateModal} onClose={handleCloseUpdateModal}>
				<AlunoUpdateForm alunoToUpdate={alunoUpdateId} />
			</CustomModal>
		</>
	);
}
