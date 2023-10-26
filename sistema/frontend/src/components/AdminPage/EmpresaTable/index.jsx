import { useState, useEffect } from "react";
import Table from "../../Table";
import { TableRow, TableCell, Button } from "@mui/material"

export default function EmpresaTable() {
    const url = 'http://localhost:8080/empresa';
    const [companies, setCompanies] = useState([{id:"123", nome: "teste teste teste", email: "teste@teste"},]);

    const columns = [
        { id: "id", label: "Id", minWidth: 50 },
        { id: "name", label: "Nome", minWidth: 50 },
        { id: "email", label: "Email", minWidth: 50 },
        { id: "cash", label: "Saldo de Moedas", minWidth: 20 },
        { id: "actionButtons", label: "Ações", minWidth: 50}
    ];
    
    function handleCreate(){
        alert("Nova empresa");
    }

    function handleUpdate(){
        alert("Atualizado")
    }
    
    function handleDelete(){
        alert("Deletado")
    }

    return(
        <>
            <Button variant="outlined" onClick={handleCreate}>Nova Empresa</Button>
            <Table columns={columns}>
                {companies.map((company) => (
                    <TableRow key={company.id}>
                        <TableCell>
                            {company.id}
                        </TableCell>
                        <TableCell>
                            {company.nome}
                        </TableCell>
                        <TableCell>
                            {company.email}
                        </TableCell>
                        <TableCell>
                            {company.saldoDeMoedas}
                        </TableCell>
                        <TableCell className="action-buttons">
                            <Button variant="outlined" onClick={handleUpdate}>Atualizar</Button>
                            <Button variant="outlined" onClick={handleDelete} color="error">Deletar</Button>
                        </TableCell>
                    </TableRow>
                ))}
            </Table>
        </>
    )
}