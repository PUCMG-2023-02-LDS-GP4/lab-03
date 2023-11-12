import { Fragment } from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Login from "../components/LoginPage/Login/Login";
import Cadastro from "../components/Cadastro/Cadastro";
import AdminPage from "../components/AdminPage/AdminPage";
import AlunoPage from "../components/AlunoPage/AlunoPage";
import EmpresaPage from "../components/EmpresaPage/EmpresaPage";

const RoutesApp = () => {
	return (
		<BrowserRouter>
			<Fragment>
				<Routes>
					<Route path='*' element={<AlunoPage />} />
					<Route path='/' element={<AlunoPage />} />
					<Route exact path='/cadastro' element={<AlunoPage />} />
					{/* {localStorage.getItem("isAutenticated") ? ( */}
					<Route exact path='/admin' element={<AdminPage />} />
					<Route exact path='/aluno' element={<AlunoPage />} />
					<Route exact path='/empresa' element={<EmpresaPage />} />
					{/* ) : (
						<Route path='/' element={<Login />} />
					)} */}
				</Routes>
			</Fragment>
		</BrowserRouter>
	);
};

export default RoutesApp;
