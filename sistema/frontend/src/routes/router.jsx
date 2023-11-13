import { Fragment } from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Login from "../components/LoginPage/Login/Login";
import CadastroEmpresa from "../components/CadastroEmpresa/CadastroEmpresa";
import CadastroAluno from "../components/CadastroAluno/CadastroAluno";
import AlunoPage from "../components/AlunoPage/AlunoPage";
import EmpresaPage from "../components/EmpresaPage/EmpresaPage";
import ProfessorPage from "../components/ProfessorPage/ProfessorPage";

const RoutesApp = () => {
	return (
		<BrowserRouter>
			<Fragment>
				<Routes>
					<Route path='*' element={<Login />} />
					<Route path='/' element={<Login />} />
					<Route exact path='/cadastroEmpresa' element={<CadastroEmpresa />} />
					<Route exact path='/cadastroAluno' element={<CadastroAluno />} />
					<Route exact path='/aluno' element={<AlunoPage />} />
					<Route exact path='/empresa' element={<EmpresaPage />} />
					<Route exact path='/professor' element={<ProfessorPage />} />
				</Routes>
			</Fragment>
		</BrowserRouter>
	);
};

export default RoutesApp;
