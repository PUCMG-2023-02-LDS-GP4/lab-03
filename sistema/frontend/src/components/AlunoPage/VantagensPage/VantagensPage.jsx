import { Box } from "@mui/material";
import { useEffect, useState } from "react";
import CardVantagem from "./CardVantagem/CardVantagem";
import Typography from "@mui/material/Typography";
import "./style.scss";
import axios from "axios";

export default function VantagensPage({ aluno }) {
	const [vantagens, setVantanges] = useState([]);
	const [empresa, setEmpresa] = useState([]);

	useEffect(() => {
		fetch(`http://localhost:8080/vantagens`)
			.then((res) => res.json())
			.then((res) => setVantanges(res));
	}, []);

	const getEmpresa = async (id) => {
		await axios
			.get(`http://localhost:8080/empresas/${id}`)
			.then((res) => setEmpresa(res.data));
	};

	function handleBuy(vantagemId) {
		let alunoId = localStorage.getItem("idUser");
		try {
			fetch(
				`http://localhost:8080/alunos/${alunoId}/vantagens/${vantagemId}/resgatar`,
				{
					method: "POST",
					body: "",
				}
			)
				.then((res) => res.json())
				.then((res) => {
					if (res) {
						const idEmpresa = res.empresaId;
						getEmpresa(idEmpresa);
					}
					alert("Vantagem Resgatada!");
					console.log(empresa)
					axios
						.post("http://localhost:5000/send-email/", {
							studentEmail: aluno.email,
							partnerEmail: empresa.email,
							studentName: aluno.nome,
							cupomStudent: res.cupom,
						})
						.then(() => {
							console.log("aizedamanga");
						});
				});
		} catch (error) {
			console.error(error.response.data);
		}
	}

	return (
		<Box sx={{ width: "100%", display: "grid" }}>
			<Typography gutterBottom variant='h5' component='h1' sx={{}}>
				Vantagens disponivéis
			</Typography>
			<Box
				sx={{
					display: "grid",
					gap: "15px",
					gridTemplateColumns: "1fr 1fr 1fr 1fr",
				}}
			>
				{vantagens.map((vantagem) => (
					<CardVantagem
						key={vantagem.id}
						vantagemId={vantagem.id}
						custoEmMoedas={vantagem.custoEmMoedas}
						descricao={vantagem.descricao}
						handleBuy={handleBuy}
						imageUrl={vantagem.foto}
						showCard={vantagem.quantidade > 0 ? "block" : "none"}
					/>
				))}
			</Box>
		</Box>
	);
}
