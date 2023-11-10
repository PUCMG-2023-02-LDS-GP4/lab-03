import { Box } from "@mui/material";
import { useState } from "react";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import Typography from "@mui/material/Typography";

export default function Profile() {
  const [professor, setProfessor] = useState({
    nome: "aluno",
    email: "aluno@gmail.com",
    cpf: "12345678910",
    rg: "MG12345678",
    endereco: "Rua Yucatan 77",
    instituicaoId: "1",
    saldoDeMoedas: "100",
    tipoUser: "Professor",
    departamento: "Ciência da Computação"
  });

  return (
    <Box sx={{ width: "100%" }}>
      <Box sx={{ display: "flex", justifyContent: "center" }}>
        <Card
          size="lg"
          variant="plain"
          orientation="horizontal"
          sx={{
            fontFamily:
              "system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif",
            borderRadius: "1rem",
            display: "flex",
            textAlign: "center",
            maxWidth: "100%",
            width: 800,
            resize: "horizontal",
            overflow: "auto",
            border: "1px solid black"
          }}
        >
          <CardContent
            sx={{
              display: "flex",
              flexDirection: "column",
              justifyContent: "center",
              alignItems: "center",
              backgroundColor: "#007FFF",
            }}
          >
            <Typography
              sx={{ fontSize: "36px", color: "#FFF", whiteSpace: "nowrap" }}
            >
              Saldo de Moedas
            </Typography>
            <Typography sx={{ fontSize: "36px", color: "#FFF" }}>
              {professor.saldoDeMoedas}
            </Typography>
          </CardContent>
          <CardContent
            sx={{
              gap: 1.5,
              minWidth: 200,
              color: "#000",
              backgroundColor: "",
              borderRadius: "0 1rem 1rem 0",
              fontSize: "36px",
            }}
          >
              <Typography sx={{ fontSize: "36px" }}>{professor.email}</Typography>
              <Typography sx={{ fontSize: "36px" }}>{professor.nome}</Typography>
              <Typography sx={{ fontSize: "36px" }}>
                {professor.departamento}
              </Typography>
          </CardContent>
        </Card>
      </Box>
    </Box>
  );
}
