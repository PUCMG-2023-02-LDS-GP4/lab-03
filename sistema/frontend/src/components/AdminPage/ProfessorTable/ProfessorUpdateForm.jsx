import Form from "../../Form/Form"


export default function ProfessorUpdateForm({professorToUpdate}) {

  const labels = [
    {id: 'nome', label: 'Nome', type: 'text'},
    {id: 'email', label: 'E-mail', type: 'text'},
    {id: 'password', label: 'Senha', type: 'password'},
    {id: 'cpf', label: 'CPF', type: 'text'},
    {id: 'endereco', label: 'Endereço', type: 'text'},
    {id: 'departamento', label: 'Departamento', type: 'text'},
    {id: 'saldoDeMoedas', label: 'Saldo de Moedas', type: 'number'},

]

const initialValues = {
    email: '',
    nome: '',
    password: '',
    cpf: '',
    endereco: '',
    Instituicao: '',
    departamento: '',
    saldoDeMoedas: 100,
}

  function getProfessorId(professorId){
    console.log(professorId)
  }

  function handleSubmit(professor){
      // TODO metódo update
    getProfessorId(professor);
    alert(`Professor ${professor} atualizado.`);
}

return(
    <>
        <Form 
        fields={labels} 
        handleSubmit={() => handleSubmit(professorToUpdate)} 
        action={"admin/createProfessor"}  
        buttonSubmitText="Novo Professor"
        fieldsInitialValues={initialValues}
        />
    </>
)
}
