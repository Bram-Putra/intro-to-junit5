package customerintake.notifier;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SmtpMessageSender {
	
	// TODO[7]: extract this method to an interface called EmailNotifier
	public void sendNotification(String subject, String body, String address) {
		/* TODO[8]: create a test double in the test.notifier that implements EmailNotifier
		 * 			and call it EmailNotifierTestDouble */
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", "localhost");
		Session session = Session.getDefaultInstance(properties, null);
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress("system@customerintake.com"));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(address));
			message.setSubject(subject);
			message.setContent(body, "text/html");
			Transport.send(message);
		} catch (Throwable t) {
			t.printStackTrace();;
		}
	}
}
