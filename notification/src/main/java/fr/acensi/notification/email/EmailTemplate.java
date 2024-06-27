package fr.acensi.notification.email;

import lombok.Getter;

public enum EmailTemplate {
    PAYMENT_CONFIRMATION("payment-confirmation.html","Payment successfully processed"),
    ACTIVITY_CONFIRMATION("activity-confirmation.html","Activity successfully processed");

    @Getter
    private final String template;
    @Getter
    private final String subject;


    EmailTemplate(String template, String subject) {
        this.template=template;
        this.subject=subject;
    }
}
