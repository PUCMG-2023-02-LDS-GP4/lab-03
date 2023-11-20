import { Box } from "@mui/material";
import { useEffect, useState } from "react";
import CardVantagem from "./CardVantagem/CardVantagem";
import Typography from "@mui/material/Typography";
import "./style.scss";
import axios from "axios";

export default function VantagensPage() {
	const [vantagens, setVantanges] = useState([]);
	const [aluno, setAluno] = useState([]);

	useEffect(() => {
		fetch(`http://localhost:8080/vantagens`)
			.then((res) => res.json())
			.then((res) => setVantanges(res));
	}, []);

	const alunoId = localStorage.getItem("idUser");
	const getAlunoEmpresa = () => {
		fetch(`http://localhost:8080/aluno/${alunoId}`)
			.then((res) => res.json())
			.then((res) => setAluno(res));

		fetch(`http://localhost:8080/vantagens`)
			.then((res) => res.json())
			.then((res) => setVantanges(res));
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
			).then((res) => {
				if (res.status === 200) {
					alert("Vantagem Resgatada!");
					getAlunoEmpresa();
					axios.post('http://localhost:5000/send-email/', {
						studentEmail: 'augustobaldiotti@hotmail.com',
						partnerEmail: 'augustobaldiotti1@hotmail.com',
						studentName: aluno.nome,
						cupomStudent: res.cupom,
					}).then(() => { console.log("aizedamanga");})
				} else {
					alert("Usuário ou Senha incorretos!");
				}
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
