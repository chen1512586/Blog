<<<<<<< HEAD
package com.cpf.demo.web;

import com.cpf.demo.model.Mail;
import com.cpf.demo.service.MailService;
import com.cpf.demo.sys.ValidateCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {
    private static Logger LOG=LoggerFactory.getLogger(MailController.class);
    @Autowired
    private MailService mailServer;

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sender;

    /*
     * 发送普通邮件
     */
    @PostMapping("/sendMail")
    public String sendMail(@RequestBody Mail mail) {
        mail.setSender(sender);
        mailServer.save(mail);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mail.getSender());
        message.setTo(mail.getReceiver());
        message.setSubject(mail.getSubject());
        message.setText("收到邮件"+ ValidateCode.createData());
        mailSender.send(message);
        LOG.info("发送成功!");
        return "success";
    }
}
=======
<<<<<<< HEAD
package com.cpf.demo.web;

import com.cpf.demo.model.Mail;
import com.cpf.demo.service.MailService;
import com.cpf.demo.sys.ValidateCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {
    private static Logger LOG=LoggerFactory.getLogger(MailController.class);
    @Autowired
    private MailService mailServer;

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sender;

    /*
     * 发送普通邮件
     */
    @PostMapping("/sendMail")
    public String sendMail(@RequestBody Mail mail) {
        mail.setSender(sender);
        mailServer.save(mail);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mail.getSender());
        message.setTo(mail.getReceiver());
        message.setSubject(mail.getSubject());
        message.setText("收到邮件"+ ValidateCode.createData());
        mailSender.send(message);
        LOG.info("发送成功!");
        return "success";
    }
}
=======
package com.cpf.demo.web;

import com.cpf.demo.model.Mail;
import com.cpf.demo.service.MailService;
import com.cpf.demo.sys.ValidateCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {
    private static Logger LOG=LoggerFactory.getLogger(MailController.class);
    @Autowired
    private MailService mailServer;

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sender;

    /*
     * 发送普通邮件
     */
    @PostMapping("/sendMail")
    public String sendMail(@RequestBody Mail mail) {
        mail.setSender(sender);
        mailServer.save(mail);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mail.getSender());
        message.setTo(mail.getReceiver());
        message.setSubject(mail.getSubject());
        message.setText("收到邮件"+ ValidateCode.createData());
        mailSender.send(message);
        LOG.info("发送成功!");
        return "success";
    }
}
>>>>>>> 6904d88... first commit
>>>>>>> 7e2b114... first commit
