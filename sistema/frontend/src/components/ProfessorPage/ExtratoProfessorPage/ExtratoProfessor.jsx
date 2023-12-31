import { useEffect, useState } from "react";
import Table from "../../Table/Table";
import { TableRow, TableCell } from "@mui/material";

export default function ExtratoAluno() {
  const [transacaoProf, setTransacaoProf] = useState([
    {
      id: "123",
      data: "24/05/23",
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

  useEffect(() => {
    let profId = localStorage.getItem("idUser");
    fetch(`http://localhost:8080/user/${profId}`)
      .then((res) => res.json())
      .then((res) => setTransacaoProf(res.extrato.listaDeTransacoes));
  }, []);

  return (
    <>
      <Table columns={columns}>
        {transacaoProf.map((transacaoprof) => (
          <TableRow key={transacaoprof.id}>
            <TableCell>{transacaoprof.id}</TableCell>
            <TableCell>{transacaoprof.data}</TableCell>
            <TableCell>{transacaoprof.quantidade}</TableCell>
            <TableCell>{transacaoprof.mensagem}</TableCell>
            <TableCell className="action-buttons"></TableCell>
          </TableRow>
        ))}
      </Table>
    </>
  );
}
