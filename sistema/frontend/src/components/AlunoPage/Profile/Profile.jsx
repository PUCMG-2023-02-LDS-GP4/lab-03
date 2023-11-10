import { Box } from "@mui/material";
import { useState } from "react";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import Typography from "@mui/material/Typography";
import Table from "../../Table/Table";
import { TableRow, TableCell } from "@mui/material";

export default function Profile() {
  const [aluno, setAluno] = useState({
    email: "aluno@gmail.com",
    nome: "aluno",
    password: "123456",
    cpf: "12345678910",
    rg: "MG12345678",
    endereco: "Rua Yucatan 77",
    Instituicao: "Exatas",
    curso: "Engenharia de Software",
    saldoDeMoedas: "10",
    tipoUser: "ALUNO",
    cupons: [
      {id: 5, codigo: "1KL42DS", vantagem: "aiai"}
    ]
  });

  const columns = [
    { id: "id", label: "ID", minWidth: 50 },
    { id: "codigo", label: "Código", minWidth: 50 },
    { id: "vantagem", label: "Vantagem", minWidth: 50 },
  ];

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
              sx={{ fontSize: "36px", color: "#000", whiteSpace: "nowrap" }}
            >
              Saldo de Moedas
            </Typography>
            <Typography sx={{ fontSize: "36px", color: "#000" }}>
              {aluno.saldoDeMoedas}
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
              <Typography sx={{ fontSize: "36px" }}>{aluno.email}</Typography>
              <Typography sx={{ fontSize: "36px" }}>{aluno.nome}</Typography>
              <Typography sx={{ fontSize: "36px" }}>
                {aluno.Instituicao}
              </Typography>
              <Typography sx={{ fontSize: "36px" }}>{aluno.curso}</Typography>
          </CardContent>
        </Card>
      </Box>
      <Typography gutterBottom variant="h5" component="h1" sx={{}}>
        Vantagens obtidas
      </Typography>
      <Table columns={columns}>
        {aluno.cupons.map((cupom) => (
          <TableRow key={cupom.id}>
            <TableCell>{cupom.id}</TableCell>
            <TableCell>{cupom.codigo}</TableCell>
            <TableCell>{cupom.vantagem}</TableCell>
          </TableRow>
        ))}
      </Table>
    </Box>
  );
}
