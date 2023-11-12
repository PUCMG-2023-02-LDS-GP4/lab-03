import React from 'react'
import { useEffect, useState } from "react";
import Table from "../../Table/Table";
import { TableRow, TableCell} from "@mui/material";

export default function ExtratoAluno() {
    const [transacao, setTransacao] = useState([
		{
			id: "123",
			data: "11/11/23",
			quantidade: "20",
			mensagem: "teste",
		},
	]);

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
						<TableCell className='action-buttons'>
						</TableCell>
					</TableRow>
				))}
			</Table>
            </>
	);
}
