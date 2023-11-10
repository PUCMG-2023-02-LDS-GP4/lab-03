import { Box } from "@mui/material";
import Form from "../../Form/Form";
import Typography from "@mui/material/Typography";
import Modal from "@mui/material/Modal";
import Button from "@mui/material/Button"
import { useState } from "react";

const style = {
  position: "absolute",
  alignItems: "center",
  justifyContent: "center",
  textAlign: "center",
  borderRadius: "1rem",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  width: 400,
  bgcolor: "background.paper",
  boxShadow: 24,
  p: 4,
};

export default function MoedaPage() {
  const [openModal, setOpenModal] = useState(false);
  const [aluno, setAluno] = useState("Teste");

  const handleOpen = () => {
    setOpenModal(true);
  };

  const handleClose = () => {
    setOpenModal(false);
  };

  function submit({ professorId, alunoId, quantidade }) {
    alert("teste");
  }

  const initialValues = {
    alunoId: "",
    quantidade: "",
  };

  const labels = [
    { id: "alunoId", label: "ID do Aluno", type: "text" },
    { id: "quantidade", label: "Quantidade de Moedas", type: "number" },
  ];

  return (
    <Box sx={{ width: "100%" }}>
      <Box
        sx={{
          display: "grid",
          alignItems: "center",
          justifyContent: "center",
          textAlign: "center",
        }}
      >
        <Typography gutterBottom variant="h5" component="h1">
          Enviar moedas
        </Typography>
        <Form
          fields={labels}
          submit={handleOpen}
          action={"/professores/enviarMoedas"}
          buttonSubmitText="Enviar Moedas"
          fieldsInitialValues={initialValues}
          buttonColor="primary"
        />
      </Box>

      <Modal
        keepMounted
        open={openModal}
        onClose={handleClose}
        aria-labelledby="keep-mounted-modal-title"
        aria-describedby="keep-mounted-modal-description"
      >
        <Box sx={style}>
          <Typography id="keep-mounted-modal-title" variant="h6" component="h2">
            Você está prestes a mandar moedas para:
          </Typography>
          <Typography id="keep-mounted-modal-description" variant="h4" component="h2">
            {aluno}
          </Typography>
          <Typography id="keep-mounted-modal-title" variant="h6" component="h2">
            Você deseja enviar as moedas?
          </Typography>
          <Box sx={{display: "flex", justifyContent:"center", alignItems:"center", gap: "10px"}}>
            <Button variant="contained" onClick={submit} color="primary" sx={{marginTop: "8px"}}>
              Enviar
            </Button>
            <Button variant="outlined" onClick={handleClose} color="primary" sx={{marginTop: "8px"}}>
              Não enviar
            </Button>
          </Box>
        </Box>
      </Modal>
    </Box>
  );
}
