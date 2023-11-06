import { Fragment } from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Login from "../components/LoginPage/Login/Login";
import Cadastro from "../components/Cadastro/Cadastro";

const RoutesApp = () => {
	return (
		<BrowserRouter>
			<Fragment>
				<Routes>
					<Route exact path='/home' element={<h1>Logado</h1>} />
					<Route path='/' element={<Login />} />
					<Route exact path='/cadastro' element={<Cadastro />} />
					<Route path='*' element={<Login />} />
				</Routes>
			</Fragment>
		</BrowserRouter>
	);
};

export default RoutesApp;
