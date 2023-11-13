import { Box, Button } from "@mui/material";
import { useState, useEffect } from "react";
import CardVantagem from "./CardVantagem/CardVantagem";
import Typography from "@mui/material/Typography";
import CustomModal from "../../CustomModal/CustomModal";
import CreateVantagemModal from "./CreateVantagemModal/CreateVantagemModal";
import "./style.scss";

export default function VantagensPage() {
	const [empresa, setEmpresa] = useState({
		email: "empresa@uiui.com",
		nome: "Empresa Uiui",
		tipoUser: "EMPRESA",
		listaDeVantagens: [
		{id: 5, descricao: "Metade do dobro do preço", custoEmMoedas: 3, quantidade: 100}
		]});


		useEffect(() => {
			let empresaId = localStorage.getItem("idUser")
			fetch(`http://localhost:8080/empresas/${empresaId}`)
				.then((res) => res.json())
				.then((res) => setEmpresa(res));
		}, []);

	const [showCreateModal, setShowCreateModal] = useState(false);

	function handleCreate() {
		setShowCreateModal(true);
	}

	function handleCloseCreateModal() {
		setShowCreateModal(false);
	}

	return (
		<>
			<Box sx={{marginBottom: "10px"}}>
				<Button variant='outlined' onClick={handleCreate}>
					Nova Vantagem
				</Button>
			</Box>
			<Box sx={{ width: "100%", display: "grid" }}>
				<Typography gutterBottom variant='h5' component='h1' sx={{}}>
					Vantagens criadas
				</Typography>
				<Box sx={{ display: "flex", gap: "10px" }}>
					{empresa.listaDeVantagens.map((vantagem) => (
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
				<CreateVantagemModal />
			</CustomModal>

		</>
	);
}
