package fr.acensi.notification.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;


    @Async
    public void sendPaymentSuccessEmail(
            String destination,
            String customer,
            BigDecimal amount,
            String activity
    ) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper =
                new MimeMessageHelper(mimeMessage,MimeMessageHelper.MULTIPART_MODE_RELATED, StandardCharsets.UTF_8.name());
        messageHelper.setFrom("toujani.chams@gmail.com");
        final String templateName = EmailTemplate.PAYMENT_CONFIRMATION.getTemplate();
        Map<String, Object> variables = new HashMap<>();
        variables.put("customer", customer);
        variables.put("amount", amount);
        variables.put("activity", activity);

        Context context = new Context();
        context.setVariables(variables);
        messageHelper.setSubject(EmailTemplate.PAYMENT_CONFIRMATION.getSubject());

        try {
            String htmlTemplate = templateEngine.process(templateName,context);
            messageHelper.setText(htmlTemplate,true);
            messageHelper.setTo(destination);
            mailSender.send(mimeMessage);
            log.info(String.format("Mail set to %s with %s",destination,templateName));
        } catch (MessagingException | MailException e) {
            log.warn(String.format("Mail not set to %s with %s",destination,templateName));
        }
    }

    @Async
    public void sendActivityConfirmationEmail(
            String destination,
            String customer,
            BigDecimal amount,
            String activity
    ) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper =
                new MimeMessageHelper(mimeMessage,MimeMessageHelper.MULTIPART_MODE_RELATED, StandardCharsets.UTF_8.name());
        messageHelper.setFrom("toujani.chams@gmail.com");

        final String templateName = EmailTemplate.ACTIVITY_CONFIRMATION.getTemplate();
        Map<String, Object> variables = new HashMap<>();
        variables.put("customer", customer);
        variables.put("totalAmount", amount);
        variables.put("activity", activity);

        Context context = new Context();
        context.setVariables(variables);
        messageHelper.setSubject(EmailTemplate.ACTIVITY_CONFIRMATION.getSubject());

        try {
            String htmlTemplate = templateEngine.process(templateName,context);
            messageHelper.setText(htmlTemplate,true);
            messageHelper.setTo(destination);
            mailSender.send(mimeMessage);
            log.info(String.format("Mail set to %s with %s",destination,templateName));
        } catch (MessagingException | MailException e) {
            log.warn(String.format("Mail not set to %s with %s",destination,templateName));
        }
    }

}
