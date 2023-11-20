import * as React from "react";
import { useState, useEffect } from "react";
import PropTypes from "prop-types";
import Tabs from "@mui/material/Tabs";
import Tab from "@mui/material/Tab";
import Typography from "@mui/material/Typography";
import Box from "@mui/material/Box";
import Profile from "../Profile/Profile";
import VantagensPage from "../VantagensPage/VantagensPage";
import ExtratoAlunoPage from "../ExtratoAlunoPage/ExtratoAluno";

function CustomTabPanel(props) {
	const { children, value, index, ...other } = props;

	return (
		<div
			role='tabpanel'
			hidden={value !== index}
			id={`simple-tabpanel-${index}`}
			aria-labelledby={`simple-tab-${index}`}
			{...other}
		>
			{value === index && (
				<Box sx={{ p: 3 }}>
					<Typography>{children}</Typography>
				</Box>
			)}
		</div>
	);
}

CustomTabPanel.propTypes = {
	children: PropTypes.node,
	index: PropTypes.number.isRequired,
	value: PropTypes.number.isRequired,
};

function a11yProps(index) {
	return {
		id: `simple-tab-${index}`,
		"aria-controls": `simple-tabpanel-${index}`,
	};
}

export default function Header() {
	const [aluno, setAluno] = useState();
	const [value, setValue] = React.useState(0);

	useEffect(() => {
		let alunoId = localStorage.getItem("idUser");
		fetch(`http://localhost:8080/alunos/${alunoId}`)
			.then((res) => res.json())
			.then((res) => setAluno(res));
	}, []);

	const handleChange = (event, newValue) => {
		setValue(newValue);
	};

	return (
		<Box sx={{ width: "100%" }}>
			<Box sx={{ borderBottom: 1, borderColor: "divider" }}>
				<Tabs value={value} onChange={handleChange}>
					<Tab label='Perfil' {...a11yProps(0)} />
					<Tab label='Extrato' {...a11yProps(1)} />
					<Tab label='Vantagens' {...a11yProps(2)} />
				</Tabs>
			</Box>
			<CustomTabPanel value={value} index={0}>
				<Profile aluno={aluno} />
			</CustomTabPanel>
			<CustomTabPanel value={value} index={1}>
				<ExtratoAlunoPage />
			</CustomTabPanel>
			<CustomTabPanel value={value} index={2}>
				<VantagensPage aluno={aluno} />
			</CustomTabPanel>
		</Box>
	);
}
