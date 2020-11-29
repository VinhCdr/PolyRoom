package poro.module.mail;

import java.io.File;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author vinh
 */
public class MailContent {

    public MailContent() {
        multipart = new MimeMultipart();
    }

    private String mailReceiver;
    private String subject;
    private String text;
    private Multipart multipart;

    /**
     * Thêm file vào tin nhắn
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
     * Đặt địa chỉ người nhận
     *
     * @param mailReceiver Địa chỉ mail người nhận
     */
    public void setMailReceiver(String mailReceiver) {
        this.mailReceiver = mailReceiver;
    }
    
    public String getMailReceiver() {
        return mailReceiver;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

    Multipart getMultipart() {
        return multipart;
    }
}
