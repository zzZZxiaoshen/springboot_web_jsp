package cn.pinghu.springboot_web_jsp.utils;

import com.sun.org.apache.bcel.internal.generic.NEW;
import io.github.biezhi.ome.OhMyEmail;
import io.github.biezhi.ome.SendMailException;
import org.springframework.beans.propertyeditors.FileEditor;

import java.io.File;
import java.util.ArrayList;

import static io.github.biezhi.ome.OhMyEmail.SMTP_QQ;


/**
 * 发送邮件工具类
 * @author shenkai
 * @date 2018/12/28
 */
public class EmailUtils {

    static {
        OhMyEmail.config(SMTP_QQ(false), "644921352@qq.com", "flcvjlugxnijbfgb");
    }

    /**
     * 邮件封装对象
     * @author shenkai
     * @date 2018/12/28
     */
    public static class Email{
        private String name;
        private String sendName;
        private String emailNum;
        private String text;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSendName() {
            return sendName;
        }

        public void setSendName(String sendName) {
            this.sendName = sendName;
        }

        public String getEmailNum() {
            return emailNum;
        }

        public void setEmailNum(String emailNum) {
            this.emailNum = emailNum;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    /**
     * 附件形式的邮件
     * @author shenkai
     * @date 2018/12/28
     */
    public static class FileEmail extends Email {
       private ArrayList<File> files = new ArrayList<File>();

        public void add(File file) {
            files.add(file);
        }
    }

    /**
    * 发送邮件
    * @param email 邮件对象信息
    */
    public static boolean sendEmail(Email email) throws SendMailException {
        OhMyEmail ohMyEmail = null;
        try {
            if (email != null) {
              OhMyEmail.subject(email.getName()).from(email.sendName)
                        .to(email.emailNum)
                        .text(email.text);
                if (email instanceof FileEmail) {
                    for (File file : ((FileEmail) email).files) {
                        ohMyEmail.attach(file);
                    }
                }
                ohMyEmail.send();
                return true;
            }
        } catch (SendMailException e) {
            return false;
        }
        return false;
    }

}
