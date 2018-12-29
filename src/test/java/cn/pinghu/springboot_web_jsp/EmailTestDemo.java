package cn.pinghu.springboot_web_jsp;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import io.github.biezhi.ome.OhMyEmail;
import io.github.biezhi.ome.SendMailException;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

import static io.github.biezhi.ome.OhMyEmail.SMTP_QQ;

public class EmailTestDemo {
    @Before
    public void before() throws GeneralSecurityException {
        // 配置，一次即可
        OhMyEmail.config(SMTP_QQ(false), "644921352@qq.com", "flcvjlugxnijbfgb");
    }

    @Test
    public void testSendText() throws MessagingException, SendMailException {
        sendEmail();
        return;
    }

    private void sendEmail() throws SendMailException {
        OhMyEmail.subject("这是一封测试 TEXT 邮件")
                .from("小姐姐的邮箱")
                .to("shenkai@marsfood.cn")
                .text("信件内容")
                .send();
    }

    @Test
    public void testSendHtml() throws MessagingException, SendMailException {
        OhMyEmail.subject("这是一封测试 HTML 邮件")
                .from("小姐姐的邮箱")
                .to("shenkai@marsfood.cn")
                .html("<h1 font=red>信件内容</h1>")
                .send();
    }

    @Test
    public void testSendAttach() throws MessagingException, SendMailException {
        OhMyEmail.subject("这是一封测试附件邮件")
                .from("小姐姐的邮箱")
                .to("shenkai@marsfood.cn")
                .html("<h1 font=red>信件内容</h1>")
                .attach(new File("C:\\Users\\lx\\Desktop\\沈凯的个人文件夹\\数据导入\\订单列表.xls"), "订单列表.xls")
                .send();
    }

    @Test
    public void testSendAttachURL() throws MessagingException, SendMailException {
        try {
            OhMyEmail.subject("这是一封测试网络资源作为附件的邮件")
                    .from("小姐姐的邮箱")
                    .to("shenkai@marsfood.cn")
                    .html("<h1 font=red>信件内容</h1>")
                    .attachURL(new URL("https://avatars1.githubusercontent.com/u/2784452?s=40&v=4"), "测试图片.jpeg")
                    .send();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


}
