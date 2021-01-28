package br.com.alura.escola.infra.indicacao;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.alura.escola.aplicacao.indicacao.EnviarEmailIndicacao;
import br.com.alura.escola.dominio.aluno.Aluno;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {

	@Override
	public void enviarPara(Aluno indicado) {
		      String to = indicado.getEmail();
		      String from = "escolaAlura@gmail.com";
		      String host = "HOST";

		      Properties props = new Properties();
		      props.put("mail.smtp.auth", "true");
		      props.put("mail.smtp.starttls.enable", "true");
		      props.put("mail.smtp.host", host);

		      Session session = Session.getInstance(props);
		  
		      try {
			   Message message = new MimeMessage(session); //criada mensagem padrão
			   message.setFrom(new InternetAddress(from)); //seta endereco de origem
			   message.setRecipients(Message.RecipientType.TO,
		               InternetAddress.parse(to));			//seta endereco do aluno indicado
			
			   message.setSubject("Bem-vindo(a) a Alura!"); //cabeçalho
			   message.setText("Parabéns,\n sua matricula foi realizada com sucesso!\n\nEscola Alura");

			   Transport.send(message); //envia a msg

			   System.out.println("Sent message successfully....");

		      } catch (MessagingException e) {
		         throw new RuntimeException(e);
		      }		   
	}
}
