import Form from "../../Form/Form"

export default function ProfessorForm() {

    const url = "";

    function handleSubmit(){
    // TODO fazer requisição post
    /*
        event.preventDefault();

    try {
      const response = await fetch(url, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
      });

      if (!response.ok) {
        throw new Error('Erro ao enviar o formulário');
      }

      const data = await response.json();
      console.log('Dados enviados com sucesso:', data);
    } catch (error) {
      console.error('Erro ao enviar o formulário:', error);
    }
  };
  */

        alert("Funcionou")
    }


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

    return(
        <>
            <Form 
            fields={labels} 
            handleSubmit={handleSubmit} 
            action={"admin/createProfessor"}  
            buttonSubmitText="Novo Professor"
            fieldsInitialValues={initialValues}
            />
        </>
    )
}
