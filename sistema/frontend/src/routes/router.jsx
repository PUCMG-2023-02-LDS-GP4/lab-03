import { Fragment } from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Login from "../components/LoginPage/Login/Login";
import Cadastro from "../components/Cadastro/Cadastro";
import AdminPage from "../components/AdminPage/AdminPage";

const RoutesApp = () => {
	return (
		<BrowserRouter>
			<Fragment>
				<Routes>
					<Route path='*' element={<Login />} />
					<Route path='/' element={<Login />} />
					<Route exact path='/cadastro' element={<Cadastro />} />
					{localStorage.getItem("isAutenticated") ? (
						<Route exact path='/home' element={<AdminPage />} />
					) : (
						<Route path='/' element={<Login />} />
					)}
				</Routes>
			</Fragment>
		</BrowserRouter>
	);
};

export default RoutesApp;
