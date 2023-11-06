import { useEffect, useState } from "react";
import Table from "../../Table/Table";
import { TableRow, TableCell, Button } from "@mui/material";
import ProfessorCreateForm from "./ProfessorCreateForm";
import ProfessorUpdateForm from "./ProfessorUpdateForm";
import CustomModal from "../../CustomModal/CustomModal";

export default function ProfessorTable() {
	// const url = 'http://localhost:8080/professor';
	const [professors, setProfessor] = useState([
		{
			id: 123,
			nome: "teste teste teste",
			email: "teste@teste",
			saldoDeMoedas: 0,
			departamento: "a",
			instituicao: "a",
		},
	]);
	const [showCreateModal, setShowCreateModal] = useState(false);
	const [showUpdateModal, setShowUpdateModal] = useState(false);
	const [professorUpdateId, setProfessorUpdateId] = useState();

	useEffect(() => {
		fetch("http://localhost:8080/professores")
			.then((res) => res.json())
			.then((res) => setProfessor(res));
	}, []);

	const columns = [
		{ id: "id", label: "Id", minWidth: 50 },
		{ id: "name", label: "Nome", minWidth: 50 },
		{ id: "mail", label: "Email", minWidth: 50 },
		{ id: "department", label: "Departamento", minWidth: 50 },
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

	function handleUpdate(professorId) {
		setShowUpdateModal(true);
		setProfessorUpdateId(professorId);
	}

	function handleCloseUpdateModal() {
		setShowUpdateModal(false);
	}

	function handleDelete(professorToDelete) {
		alert(`Professor ${professorToDelete} foi deletado`);
	}

	return (
		<>
			<Button variant='outlined' onClick={handleCreate}>
				Novo Professor
			</Button>
			<Table columns={columns}>
				{professors.map((professor) => (
					<TableRow key={professor.id}>
						<TableCell>{professor.id}</TableCell>
						<TableCell>{professor.nome}</TableCell>
						<TableCell>{professor.email}</TableCell>
						<TableCell>{professor.departamento}</TableCell>
						<TableCell>{professor.instituicao}</TableCell>
						<TableCell>{professor.saldoDeMoedas}</TableCell>
						<TableCell className='action-buttons'>
							<Button
								variant='outlined'
								onClick={() => handleUpdate(professor.id)}
							>
								Atualizar
							</Button>
							<Button
								variant='outlined'
								onClick={() => handleDelete(professor.id)}
								color='error'
							>
								Deletar
							</Button>
						</TableCell>
					</TableRow>
				))}
			</Table>

			<CustomModal isOpen={showCreateModal} onClose={handleCloseCreateModal}>
				<ProfessorCreateForm />
			</CustomModal>

			<CustomModal isOpen={showUpdateModal} onClose={handleCloseUpdateModal}>
				<ProfessorUpdateForm professorToUpdate={professorUpdateId} />
			</CustomModal>
		</>
	);
}
