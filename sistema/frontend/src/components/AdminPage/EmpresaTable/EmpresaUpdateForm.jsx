import Form from "../../Form/Form"

export default function EmpresaUpdateForm({empresaToUpdate}) {

  
  const labels = [
    {id: 'email', label: 'E-mail', type: 'text'},
    {id: 'nome', label: 'Nome', type: 'text'},
    {id: 'password', label: 'Senha', type: 'password'}
  ] 

  const initialValues = {
    email: '',
    nome: '',
    password: ''
  }

  function handleSubmit(empresaId){
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

      alert(`Empresa ${empresaId} atualizada.`)
  }

  return(
      <>
          <Form 
          fields={labels} 
          handleSubmit={() => handleSubmit(empresaToUpdate)} 
          action={"/empresa"}  
          buttonSubmitText="Nova empresa"
          fieldsInitialValues={initialValues}
          />
      </>
  )
  }
  