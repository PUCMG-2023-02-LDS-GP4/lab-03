import styled from "styled-components";

export const Container = styled.div`
	display: flex;
	align-items: center;
	justify-content: center;
	flex-direction: column;
	gap: 10px;
	height: 100vh;
`;

export const Content = styled.form`
	gap: 15px;
	display: flex;
	align-items: center;
	justify-content: center;
	flex-direction: column;
	width: 100%;
	box-shadow: 0 1px 2px #0003;
	background-color: white;
	max-width: 350px;
	padding: 20px;
	border-radius: 5px;
`;

export const Input = styled.input`
	outline: none;
	padding: 16px 20px;
	width: 100%;
	border-radius: 5px;
	font-size: 16px;
	background-color: #f0f2f5;
	border: none;
`;

export const Label = styled.label`
	font-size: 18px;
	font-weight: 600;
	color: #676767;
`;

export const LabelSignup = styled.label`
	display: flex;
	flex-direction: column;
	align-items: center;
	gap: 5px;
	font-size: 16px;
	color: #676767;
`;

export const labelError = styled.label`
	font-size: 14px;
	color: red;
`;

export const Strong = styled.strong`
	display: flex;
	flex-direction: column;
	align-items: center;
	gap: 5px;
	cursor: pointer;

	a {
		text-decoration: none;
		color: #676767;
	}
`;
