import {
  Box,
  FormControl,
  FormGroup,
  Input,
  InputLabel,
  Button,
} from "@mui/material";
import Typography from "@mui/material/Typography";
import Modal from "@mui/material/Modal";
import { useState } from "react";
import { useForm } from "react-hook-form";
import axios from "axios";

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
  const { register, handleSubmit } = useForm();

  const handleOpen = () => {
    setOpenModal(true);
  };

  const handleClose = () => {
    setOpenModal(false);
  };

  const handleClick = (e) => {
    submit(e);
  };

  function submit({ alunoId, quantidade }) {
    fetch(`http://localhost:8080/alunos/${alunoId}`)
      .then((res) => res.json())
      .then((res) => setAluno(res));

    try {
      axios
        .post(
          "http://localhost:8080/professores/enviarMoedas",
          {
            professorId: localStorage.getItem("idUser"),
            alunoId: alunoId,
            quantidade: quantidade,
          },
          {
            headers: { "Content-Type": "application/json" },
          }
        )
        .then((res) => {
          if (res.status === 200) {
            alert("Moedas enviadas!");
          }
        });
    } catch (error) {
      console.error(error.response.data);
    }
  }

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

        <FormGroup>
          {labels.map((field) => (
            <FormControl key={field.id} className="field-container">
              <InputLabel htmlFor={field.id}>{field.label}</InputLabel>
              <Input
                type={field.type}
                id={field.id}
                name={field.id}
                {...register(field.id)}
              />
            </FormControl>
          ))}
          <Button
            color="primary"
            variant="outlined"
            sx={{ marginTop: "10px" }}
            onClick={handleOpen}
          >
            Enviar moedas
          </Button>
        </FormGroup>
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
          <Typography
            id="keep-mounted-modal-description"
            variant="h4"
            component="h2"
          >
            {aluno.nome}
          </Typography>
          <Typography id="keep-mounted-modal-title" variant="h6" component="h2">
            Você deseja enviar as moedas?
          </Typography>
          <Box
            sx={{
              display: "flex",
              justifyContent: "center",
              alignItems: "center",
              gap: "10px",
            }}
          >
            <Button
              variant="contained"
              onClick={handleSubmit(handleClick)}
              color="primary"
              sx={{ marginTop: "8px" }}
            >
              Enviar
            </Button>
            <Button
              variant="outlined"
              onClick={handleClose}
              color="primary"
              sx={{ marginTop: "8px" }}
            >
              Não enviar
            </Button>
          </Box>
        </Box>
      </Modal>
    </Box>
  );
}
