package poro.module.mail;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import poro.Config;

/**
 *
 * @author vinh
 */
public class MailSender {

    public MailSender() {
        config = new Config();
    }

    private Config config;

    /**
     * Tạo phiên gửi email
     */
    private Session getSession() {
        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(config.getMailAccount(), config.getMailPass());
            }

        });
        return session;
    }

    /**
     * Gửi email từ mail mặc định
     * 
     * @param content Nội dung của email
     */
    public void send(MailContent content) throws RuntimeException {
        try {
            MimeMessage mimeMessage = new MimeMessage(getSession());
            mimeMessage.setFrom(new InternetAddress(config.getMailAccount(), config.getMailName()));
            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(content.getMailReceiver()));
            
            mimeMessage.setSubject(content.getSubject());
            mimeMessage.setText(content.getText(), "UTF-8", "html");
            if (content.getMultipart().getCount() > 0) {
                mimeMessage.setContent(content.getMultipart());
            }
            
            Transport.send(mimeMessage);
        } catch (Exception ex) {
            throw new RuntimeException("Có lỗi xảy ra trong quá trình gửi email", ex);
        }
    }
    
}
