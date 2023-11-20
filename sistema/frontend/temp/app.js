import express from "express";
import bodyParser from "body-parser";
import sgMail from "@sendgrid/mail";
import cors from "cors";

sgMail.setApiKey(
	""
);

const app = express();

app.use(cors());
app.use(express.json());
app.use(bodyParser.urlencoded({ extended: true }));

app.post("/send-email", async (req, res) => {
	const { studentEmail, partnerEmail, studentName, cupomStudent } = req.body;

	const studentMsg = {
		to: studentEmail, // Change to your recipient
		from: "1325163@sga.pucminas.br", // Change to your verified sender
		subject: "Vantagem Resgatada",
		text: "AAAA",
		html: `
			<div>
			  <h1>Olá, ${studentName}!</h1>
			  <p>Você acabou de resgatar o seguinte cupom: ${cupomStudent}</p>
			</div>
		`,
	};

	const partnertMsg = {
		to: partnerEmail, // Change to your recipient
		from: "1325163@sga.pucminas.br", // Change to your verified sender
		subject: "Vantagem Resgatada",
		text: "AAAA",
		html: `
		<div>
		  <h1>Olá!</h1>
		  <p>O aluno ${studentName} acabou de resgatar o seguinte cupom: ${cupomStudent}</p>
		</div>
	`,
	};

	await sgMail
		.send(studentMsg)
		.then(() => {
			console.log("Email sent");
		})
		.catch((error) => {
			console.error(error.response.body.errors);
		});

	await sgMail
		.send(partnertMsg)
		.then(() => {
			console.log("Email sent");
		})
		.catch((error) => {
			console.error(error);
		});
});

app.listen(5000, () => {
	console.log("SERVIDOR STARTOU");
});
