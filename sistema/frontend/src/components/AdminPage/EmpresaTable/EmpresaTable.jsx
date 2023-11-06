import { useEffect, useState } from "react";
import Table from "../../Table/Table";
import { TableRow, TableCell, Button } from "@mui/material";
import CustomModal from "../../CustomModal/CustomModal";
import EmpresaCreateForm from "./EmpresaCreateForm";
import EmpresaUpdateForm from "./EmpresaUpdateForm";

export default function EmpresaTable() {
	// const url = 'http://localhost:8080/empresa';
	const [companies, setCompanies] = useState([
		{ id: "123", nome: "teste teste teste", email: "teste@teste" },
	]);
	const [showCreateModal, setShowCreateModal] = useState(false);
	const [showUpdateModal, setShowUpdateModal] = useState(false);
	const [empresaUpdateId, setEmpresaUpdateId] = useState();

	useEffect(() => {
		fetch("http://localhost:8080/empresas")
			.then((res) => res.json())
			.then((res) => setCompanies(res));
	}, []);

	const columns = [
		{ id: "id", label: "Id", minWidth: 50 },
		{ id: "name", label: "Nome", minWidth: 50 },
		{ id: "email", label: "Email", minWidth: 50 },
		{ id: "cash", label: "Saldo de Moedas", minWidth: 20 },
		{ id: "actionButtons", label: "Ações", minWidth: 50 },
	];

	function handleCreate() {
		setShowCreateModal(true);
	}

	function handleCloseCreateModal() {
		setShowCreateModal(false);
	}

	function handleUpdate(empresaToUpdate) {
		setShowUpdateModal(true);
		setEmpresaUpdateId(empresaToUpdate);
	}

	function handleCloseUpdateModal() {
		setShowUpdateModal(false);
	}

	function handleDelete(empresaToDelete) {
		alert(`Empresa ${empresaToDelete} foi deletado`);
	}

	return (
		<>
			<Button variant='outlined' onClick={handleCreate}>
				Nova Empresa
			</Button>
			<Table columns={columns}>
				{companies.map((company) => (
					<TableRow key={company.id}>
						<TableCell>{company.id}</TableCell>
						<TableCell>{company.nome}</TableCell>
						<TableCell>{company.email}</TableCell>
						<TableCell>{company.saldoDeMoedas}</TableCell>
						<TableCell className='action-buttons'>
							<Button
								variant='outlined'
								onClick={() => handleUpdate(company.id)}
							>
								Atualizar
							</Button>
							<Button
								variant='outlined'
								onClick={() => handleDelete(company.id)}
								color='error'
							>
								Deletar
							</Button>
						</TableCell>
					</TableRow>
				))}
			</Table>
			<CustomModal isOpen={showCreateModal} onClose={handleCloseCreateModal}>
				<EmpresaCreateForm />
			</CustomModal>

			<CustomModal isOpen={showUpdateModal} onClose={handleCloseUpdateModal}>
				<EmpresaUpdateForm empresaToUpdate={empresaUpdateId} />
			</CustomModal>
		</>
	);
}
