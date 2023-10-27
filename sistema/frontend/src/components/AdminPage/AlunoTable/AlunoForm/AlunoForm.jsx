
import Form from "../../../Form/Form"

export default function AlunoForm() {

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
        {id: 'email', label: 'E-mail', type: 'text'},
        {id: 'nome', label: 'Nome', type: 'text'},
        {id: 'password', label: 'Senha', type: 'password'},
        {id: 'cpf', label: 'CPF', type: 'text'},
        {id: 'endereco', label: 'Endereço', type: 'text'},
        {id: 'Instituicao', label: 'Instuição', type: 'text'},
        {id: 'curso', label: 'Curso', type: 'text'},

    ]

    const initialValues = {
        email: '',
        nome: '',
        password: '',
        cpf: '',
        endereco: '',
        Instituicao: '',
        curso: '',
    }

    return(
        <>
            <Form 
            fields={labels} 
            handleSubmit={handleSubmit} 
            action={"/alunos"}  
            buttonSubmitText="Novo Aluno"
            fieldsInitialValues={initialValues}
            />
        </>
    )
}
