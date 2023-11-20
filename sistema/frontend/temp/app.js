import express from "express";
import bodyParser from "body-parser";
import sgMail from "@sendgrid/mail";
import cors from "cors";

sgMail.setApiKey(
	"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"
);

const app = express();

app.use(cors());
app.use(express.json());
app.use(bodyParser.urlencoded({ extended: true }));

app.post("/send-email", (req, res) => {
	const { studentEmail, partnerEmail } = req.body;

	const studentMsg = {
		to: studentEmail, // Change to your recipient
		from: "1325163@sga.pucminas.br", // Change to your verified sender
		subject: "Vantagem Resgatada",
		text: "AAAA",
		html: "<strong>PENES</strong>",
	};

	const partnertMsg = {
		to: partnerEmail, // Change to your recipient
		from: "1325163@sga.pucminas.br", // Change to your verified sender
		subject: "Vantagem Resgatada",
		text: "AAAA",
		html: "<strong>PENES</strong>",
	};

	sgMail
		.send(studentMsg)
		.then(() => {
			console.log("Email sent");
		})
		.catch((error) => {
			console.error(error);
		});

	sgMail
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
