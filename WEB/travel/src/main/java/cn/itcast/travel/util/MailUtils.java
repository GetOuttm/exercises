package cn.itcast.travel.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

/**
 * 发邮件工具类
 */
public final class MailUtils {
//    private static final String USER = "384137774@qq.com"; // 发件人称号，同邮箱地址
//    private static final String PASSWORD = "ipcpxpfsoxwzbihc"; // 如果是qq邮箱可以使户端授权码，或者登录密码


    // 发件人邮箱地址
    private static String from = "384137774@qq.com";
    // 发件人称号，同邮箱地址
    private static String user = "384137774@qq.com";
    // 发件人邮箱客户端授权码
    private static String password = "ipcpxpfsoxwzbihc";
    //发件人的邮箱服务器
    private static String mailHost = "smtp.qq.com";

    /**
     * @param to    收件人邮箱
     * @param text  邮件正文
     * @param title 标题
     */
    /* 发送验证信息的邮件 */
    public static boolean sendMail(String to, String text, String title) {
        Properties props = new Properties();
        // 设置发送邮件的邮件服务器的属性（这里使用qq的smtp服务器）
        props.put("mail.smtp.host", mailHost);
        // 需要经过授权，也就是有户名和密码的校验，这样才能通过验证（一定要有这一条）
        props.put("mail.smtp.auth", "true");
        // 用刚刚设置好的props对象构建一个session
        Session session = Session.getDefaultInstance(props);
        // 有了这句便可以在发送邮件的过程中在console处显示过程信息，供调试使用（你可以在控制台（console)上看到发送邮件的过程）
        //                session.setDebug(true);
        // 用session为参数定义消息对象
        MimeMessage message = new MimeMessage(session);
        try {
            // 加载发件人地址
            message.setFrom(new InternetAddress(from));
            // 加载收件人地址
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // 加载标题
            message.setSubject(title);
            // 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
            Multipart multipart = new MimeMultipart();
            // 设置邮件的文本内容
            BodyPart contentPart = new MimeBodyPart();
            contentPart.setContent(text, "text/html;charset=utf-8");
            multipart.addBodyPart(contentPart);
            message.setContent(multipart);
            message.saveChanges(); // 保存变化
            // 连接服务器的邮箱
            Transport transport = session.getTransport("smtp");
            // 把邮件发送出去
            transport.connect(mailHost, user, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("邮件发送成功");
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) { // 做测试用
        //String toMail="xxxxx@fenglinggame.com";
        String toMail = "13313533256@163.com";
        String text = "点击激活<a href='http://www.baidu.com'></a>";
        String title = "测试小通知";
        sendMail(toMail, text, title);
    }

}

