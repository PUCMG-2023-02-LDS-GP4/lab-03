import { useEffect, useState } from "react";
import Table from "../../Table/Table";
import { TableRow, TableCell } from "@mui/material";

export default function ExtratoAluno() {
	const [aluno, setAluno] = useState({
		email: "aluno@gmail.com",
		nome: "aluno",
		password: "123456",
		cpf: "12345678910",
		rg: "MG12345678",
		endereco: "Rua Yucatan 77",
		Instituicao: "Exatas",
		curso: "Engenharia de Software",
		saldoDeMoedas: "10",
		tipoUser: "ALUNO",
		cupons: [{ id: 5, codigo: "1KL42DS", vantagem: "aiai" }],
	});
	const [transacao, setTransacao] = useState([
		{
			id: "123",
			data: "11/11/23",
			quantidade: "20",
			mensagem: "teste",
		},
	]);

	useEffect(() => {
		let alunoId = localStorage.getItem("idUser");
		fetch(`http://localhost:8080/alunos/${alunoId}`)
			.then((res) => res.json())
			.then((res) => setAluno(res));
		fetch(`http://localhost:8080/user/${alunoId}`)
			.then((res) => res.json())
			.then((res) => setTransacao(res.extrato.listaDeTransacoes));
	}, []);

	const columns = [
		{ id: "id", label: "Id", minWidth: 50 },
		{ id: "data", label: "Data", minWidth: 50 },
		{ id: "quantidade", label: "Quantidade", minWidth: 50 },
		{ id: "mensagem", label: "Mensagem", minWidth: 50 },
	];

	return (
		<>
			<Table columns={columns}>
				{transacao.map((transacao) => (
					<TableRow key={transacao.id}>
						<TableCell>{transacao.id}</TableCell>
						<TableCell>{transacao.data}</TableCell>
						<TableCell>{transacao.quantidade}</TableCell>
						<TableCell>{transacao.mensagem}</TableCell>
						<TableCell className='action-buttons'></TableCell>
					</TableRow>
				))}
			</Table>
		</>
	);
}
