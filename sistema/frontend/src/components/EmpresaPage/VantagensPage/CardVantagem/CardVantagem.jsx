import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { Button, CardActionArea, CardActions } from '@mui/material';

export default function CardVantagem({descricao,custoEmMoedas, handleBuy,imageUrl}) {
  return (
    <Card sx={{ minWidth: 375 }}>
      <CardActionArea>
        <CardMedia
          component="img"
          height="140"
          image={imageUrl}
        />
        <CardContent>
          <Typography gutterBottom variant="h5" component="div">
            $ {custoEmMoedas}
          </Typography>
          <Typography variant="body2" color="text.secondary">
            {descricao}
          </Typography>
        </CardContent>
      </CardActionArea>
      <CardActions>
        <Button size="small" color="primary" onClick={handleBuy}>
          Adquirir
        </Button>
      </CardActions>
    </Card>
  )
}
