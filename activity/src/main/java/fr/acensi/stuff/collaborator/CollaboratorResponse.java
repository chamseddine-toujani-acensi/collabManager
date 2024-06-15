package fr.acensi.stuff.collaborator;

public record CollaboratorResponse(
        Long id,
        String firstName,
        String lastName,
        String email) {
}
