package EmailClient;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.Serializable;
import java.util.Properties;

public class SendEmail implements Serializable {

    private static final long serialVersionUID=-8307237345658518819L;
    private String date;
    private String email;
    private String subject;
    private String content;

    public SendEmail(String date, String email, String subject, String content) {
        this.date = date;
        this.email = email;
        this.subject = subject;
        this.content = content;
    }


    //Sending the mail method
    public void sendMail() {
        final String username = "aravindahwk@gmail.com";
        final String password = "zlck ihsk umbl zxmv";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            javax.mail.Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("aravindahwk@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    //Returning the date
    public String getDate() {
        return date;
    }

    //Returning the email address
    public String getEmail() {
        return email;
    }

    //Returning the subject
    public String getSubject() {
        return subject;
    }

}
