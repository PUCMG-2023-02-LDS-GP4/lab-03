import * as Styles from './styles';
import { useForm } from 'react-hook-form';


const Input = ({ type='', placeholder='', register }) => {

  return <Styles.Input type={type} placeholder={placeholder} register />;
};

export default Input;
