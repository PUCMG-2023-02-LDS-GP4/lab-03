import { Box } from "@mui/material"
import { useState } from "react";
import CardVantagem from "./CardVantagem/CardVantagem";
import Typography from '@mui/material/Typography';
import "./style.scss"

export default function VantagensPage() {

    const [ vantagens, setVantanges ] = useState([{id: 1, custoEmMoedas: 10, descricao: "uauaua"}, {id: 2, custoEmMoedas: 10, descricao: "aaaaaaaa"}]);
     
    function handleBuy() {
        alert("teste");
    }
    return (
    <Box sx={{width: "100%", display: "grid"}}>
    
        <Typography gutterBottom variant="h5" component="h1" sx={{}}>
            Vantagens disponivéis
          </Typography>
        <Box sx={{display: "flex", gap: "10px"}}>
           { vantagens.map((vantagem) => (
            <CardVantagem key={vantagem.id} custoEmMoedas={vantagem.custoEmMoedas} descricao={vantagem.descricao} handleBuy={handleBuy}/>
           ))}
        </Box>
    </Box>
  )
}
