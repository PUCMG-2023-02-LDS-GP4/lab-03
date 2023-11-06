import * as Styles from './styles';

export default function Button({ Text, onClick, Type = 'button' }) {
  return (
    <Styles.Button type={Type} onClick={onClick}>
      {Text}
    </Styles.Button>
  );
}