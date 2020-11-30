package poro.module;

import java.io.File;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author vinh
 */
public class Mailer implements Runnable{

    private String mailReceiver;
    private String subject;
    private String text;
    private Multipart multipart;

    private Mailer() {
        multipart = new MimeMultipart();
    }

    public Mailer(String mailReceiver) {
        this();
        this.mailReceiver = mailReceiver;
    }

    public Mailer(String mailReceiver, String subject, String text) {
        this();
        this.mailReceiver = mailReceiver;
        this.subject = subject;
        this.text = text;
    }

    /**
     * Đặt địa chỉ người nhận
     *
     * @param mailReceiver Địa chỉ mail người nhận
     */
    public void setMailReceiver(String mailReceiver) {
        this.mailReceiver = mailReceiver;
    }

    /**
     * Thêm tiêu đề vào tin nhắn
     *
     * @param subject tiêu đề của tin nhắn
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Thêm văn bản vào tin nhắn <b>theo dạng html đầy đủ<b>
     *
     * @param subject tiêu đề của tin nhắn
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Thêm file vào mail
     *
     * @param name Tên file hiển thị phía người nhận
     * @param path Đường dẫn đến file
     */
    public void addFile(String name, String path) {
        try {
            File file = new File(path);
            DataSource ds = new FileDataSource(file);
            DataHandler dh = new DataHandler(ds);
            BodyPart body = new MimeBodyPart();
            body.setFileName(name);
            body.setDataHandler(dh);
            multipart.addBodyPart(body);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Gửi email từ mail mặc định trong {@link Config}
     *
     * @see #setMailReceiver(java.lang.String)
     * @see #setSubject(java.lang.String)
     * @see #setText(java.lang.String)
     * @see #addFile(java.lang.String, java.lang.String)
     */
    @Override
    public void run() {
        try {
            MimeMessage mimeMessage = new MimeMessage(getSession());
            mimeMessage.setFrom(new InternetAddress(Config.MAIL_ACCOUNT, Config.MAIL_NAME));
            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailReceiver));

            mimeMessage.setSubject(subject);
            mimeMessage.setText(text, "UTF-8", "html");
            if (multipart.getCount() > 0) {
                mimeMessage.setContent(multipart);
            }

            Transport.send(mimeMessage);
        } catch (Exception ex) {
            throw new RuntimeException("Có lỗi xảy ra trong quá trình gửi email", ex);
        }
    }

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
                return new PasswordAuthentication(Config.MAIL_ACCOUNT, Config.MAIL_PASSWORD);
            }

        });
        return session;
    }
}
