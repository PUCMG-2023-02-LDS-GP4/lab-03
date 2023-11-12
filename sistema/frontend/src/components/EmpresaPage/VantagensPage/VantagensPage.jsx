import { Box, Button } from "@mui/material";
import { useState } from "react";
import CardVantagem from "./CardVantagem/CardVantagem";
import Typography from "@mui/material/Typography";
import CustomModal from "../../CustomModal/CustomModal";
import AlunoCreateForm from "../AlunoTable/AlunoCreateForm";
import AlunoUpdateForm from "../AlunoTable/AlunoUpdateForm";
import "./style.scss";

export default function VantagensPage() {
	const [vantagens, setVantanges] = useState([
		{ id: 1, custoEmMoedas: 10, descricao: "uauaua" },
		{ id: 2, custoEmMoedas: 10, descricao: "aaaaaaaa" },
	]);
	const [showCreateModal, setShowCreateModal] = useState(false);
	const [showUpdateModal, setShowUpdateModal] = useState(false);
	const [alunoUpdateId, setAlunoUpdateId] = useState();

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
				Nova Vantagem
			</Button>
			<Box sx={{ width: "100%", display: "grid" }}>
				<Typography gutterBottom variant='h5' component='h1' sx={{}}>
					Vantagens criadas
				</Typography>
				<Box sx={{ display: "flex", gap: "10px" }}>
					{vantagens.map((vantagem) => (
						<CardVantagem
							key={vantagem.id}
							custoEmMoedas={vantagem.custoEmMoedas}
							descricao={vantagem.descricao}
						/>
					))}
				</Box>
			</Box>
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
