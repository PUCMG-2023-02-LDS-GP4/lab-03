import { useState, useEffect } from "react";
import Table from "../../Table/Table";
import { TableRow, TableCell, Button } from "@mui/material"

export default function ProfessorTable() {
    const url = 'http://localhost:8080/professor';
    const [professors, setProfessor] = useState([{id:"123", nome: "teste teste teste", email: "teste@teste",saldoDeMoedas: 0, departamento: "a", instituicao: "a"},]);

    const columns = [
        { id: "id", label: "Id", minWidth: 50 },
        { id: "name", label: "Nome", minWidth: 50 },
        { id: "mail", label: "Email", minWidth: 50 },
        { id: "department", label: "Departamento", minWidth: 50 },
        { id: "institution", label: "Instituição", minWidth: 50 },
        { id: "cash", label: "Saldo de Moedas", minWidth: 20 },
        { id: "actionButtons", label: "Ações", minWidth: 50}
    ];
    
    function handleCreate(){
        console.log("Novo professor");
    }

    function handleUpdate(){
        alert("Atualizado")
    }
    
    function handleDelete(){
        alert("Deletado")
    }

    return(
        <>
            <Button variant="outlined" onClick={handleCreate}>Novo Professor</Button>
            <Table columns={columns}>
                {professors.map((professor) => (
                    <TableRow key={professor.id}>
                        <TableCell>
                            {professor.id}
                        </TableCell>
                        <TableCell>
                            {professor.nome}
                        </TableCell>
                        <TableCell>
                            {professor.email}
                        </TableCell>
                        <TableCell>
                            {professor.departamento}
                        </TableCell>
                        <TableCell>
                            {professor.instituicao}
                        </TableCell>
                        <TableCell>
                            {professor.saldoDeMoedas}
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