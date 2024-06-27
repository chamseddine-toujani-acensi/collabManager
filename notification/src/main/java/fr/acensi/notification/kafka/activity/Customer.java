package fr.acensi.notification.kafka.activity;

public record Customer(
        String id,
        String firstName,
        String lastName,
        String email,
        String address
) {
}
