package fr.acensi.stuff.activity;

public record ActivityResponse(
        int id,

        String reference,

        String description,

        String paymentMethod,

        String customer,

        String mission,

        String collaborator,

        String Employee,

        String creationDate,

        String lastUpdateDate
) {
}
