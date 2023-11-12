import { Box } from "@mui/material";
import { useState } from "react";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import Typography from "@mui/material/Typography";

export default function Profile() {
  
  const [empresa, setEmpresa] = useState({
    email: "empresa@uiui.com",
    nome: "Empresa Uiui",
    tipoUser: "EMPRESA",
    listaDeVantagens: [
      {id: 5, descricao: "Metade do dobro do preço", custoEmMoedas: 3, quantidade: 100}
    ]
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
              Vantagens criadas
            </Typography>
            <Typography sx={{ fontSize: "36px", color: "#FFF" }}>
              {empresa.listaDeVantagens.length}
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
              <Typography sx={{ fontSize: "36px" }}>{empresa.email}</Typography>
              <Typography sx={{ fontSize: "36px" }}>{empresa.nome}</Typography>
          </CardContent>
        </Card>
      </Box>
    </Box>
  );
}
