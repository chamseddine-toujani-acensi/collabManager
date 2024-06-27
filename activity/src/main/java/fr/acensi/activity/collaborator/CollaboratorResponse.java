package fr.acensi.activity.collaborator;

public record CollaboratorResponse(
        Long id,
        String firstName,
        String lastName,
        String email) {
}
