import { Modal,Box, Button } from '@mui/material';
import './style.scss'

const style = {
  position: 'absolute',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 400,
  bgcolor: 'background.paper',
  border: '2px solid #000',
  boxShadow: 24,
  p: 4,
};

const styleButton = {
  alignSelf: 'flex-end'
}

export default function CustomModal({ isOpen, onClose, children}) {

  if(!isOpen) return null;

  return (
    <>
      <Modal
        className='modal-container'
        open={isOpen}
        onClose={onClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={style}>
          <Button variant="outlined" onClick={onClose} sx={styleButton}>X</Button>
          {children}
        </Box>
      </Modal> 
    </>
  );
}