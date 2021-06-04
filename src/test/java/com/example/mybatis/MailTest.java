package com.example.mybatis;

//import org.apache.log4j2.Logger;

import com.example.MybatisApplication;
import freemarker.template.Template;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;


/**
 * 实现邮件发送：简单邮件、附件邮件、嵌入资源的邮件、模板邮件
 *
 * 694
 * mftclxedcizibbje
 *
 * 270
 * kevpqthfgskhdhed
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MybatisApplication.class)
public class MailTest {

    private Logger logger = LoggerFactory.getLogger(MailTest.class);

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private FreeMarkerConfigurer configurer;

    /**
     * 发送简单的邮件
     * @throws Exception
     */
    /*@Test
    public void sendSimpleMail() throws Exception {
        logger.info("发送简单的邮件");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("694093719@qq.com");
        message.setTo("2708261617@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容，收到请回复。");

        mailSender.send(message);
        logger.info("发送简单邮件成功！");
    }*/

    /**
     * 发送附件的邮件
     * @throws Exception
     */
    /*@Test
    public void sendAttachmentsMail() throws Exception {
        logger.info("发送附件的邮件");
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("694093719@qq.com");
        helper.setTo("2708261617@qq.com");
        helper.setSubject("主题：有附件");
        helper.setText("有附件的邮件内容，收到请回复。");

        FileSystemResource file = new FileSystemResource(new File("logo.jpg"));
        helper.addAttachment("附件-1.jpg", file);
        helper.addAttachment("附件-2.jpg", file);

        mailSender.send(mimeMessage);
        logger.info("发送附件邮件成功！");
    }*/


    /**
     * 嵌入静态资源的邮件
     *
     * 这里需要注意的是addInline函数中资源名称weixin需要与正文中cid:weixin对应起来
     */
    /*@Test
    public void sendInlineMail() throws Exception {
        logger.info("发送嵌入静态资源的邮件");
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("694093719@qq.com");
        helper.setTo("2708261617@qq.com");
        helper.setSubject("主题：嵌入静态资源");
        helper.setText("<html><body><img src=\'cid:logo\'></body></html>", true);

        FileSystemResource file = new FileSystemResource(new File("logo.jpg"));
        helper.addInline("logo", file);

        mailSender.send(mimeMessage);
        logger.info("发送嵌入静态资源的邮件成功！");
    }*/


    /**
     * 发送模板的邮件
     *
     */
    @Test
    public void sendTemplateMail() throws Exception {
        logger.info("发送模板邮件");
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("694093719@qq.com");
        helper.setTo("2708261617@qq.com");
        helper.setSubject("主题：发送模板邮件");

        Map<String, Object> model = new HashMap<>();
        model.put("username", "Tom");
        Template template = configurer.getConfiguration().getTemplate("template.vm");
        String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
        helper.setText(text, true);

        mailSender.send(mimeMessage);
        logger.info("发送模板邮件成功！");
    }

}
