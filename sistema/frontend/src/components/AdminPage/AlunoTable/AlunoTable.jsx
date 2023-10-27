import { useState } from "react";
import Table from "../../Table/Table";
import { TableRow, TableCell, Button } from "@mui/material"
import CustomModal from "../../CustomModal/CustomModal";
import AlunoForm from "./AlunoForm/AlunoForm";

export default function AlunoTable() {
    // const url = 'http://localhost:8080/alunos';
    const [students, setStudents] = useState([{id:"123", nome: "teste teste teste", email: "teste@teste",saldoDeMoedas: 0, curso: "a", instituicao: "a"},]);
    const [showModal, setShowModal] = useState(false);

    const columns = [
        { id: "id", label: "Id", minWidth: 50 },
        { id: "name", label: "Nome", minWidth: 50 },
        { id: "mail", label: "Email", minWidth: 50 },
        { id: "course", label: "Curso", minWidth: 50 },
        { id: "institution", label: "Instituição", minWidth: 50 },
        { id: "cash", label: "Saldo de Moedas", minWidth: 20 },
        { id: "actionButtons", label: "Ações", minWidth: 50}
    ];
    
    function handleCreate(){
        setShowModal(true);
    }
    
    function handleUpdate(){
        setShowModal(true);
    }
    
    function handleCloseModal(){
        setShowModal(false);
    }

    function handleDelete(){
        alert("Deletado")
    }

    return(
        <>
            <Button variant="outlined" onClick={handleCreate}>Novo Aluno</Button>
            <CustomModal isOpen={showModal} onClose={handleCloseModal}>
                <AlunoForm />
            </CustomModal>

            <Table columns={columns}>
                {students.map((student) => (
                    <TableRow key={student.id}>
                        <TableCell>
                            {student.id}
                        </TableCell>
                        <TableCell>
                            {student.nome}
                        </TableCell>
                        <TableCell>
                            {student.email}
                        </TableCell>
                        <TableCell>
                            {student.curso}
                        </TableCell>
                        <TableCell>
                            {student.instituicao}
                        </TableCell>
                        <TableCell>
                            {student.saldoDeMoedas}
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