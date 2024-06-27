package fr.acensi.collaborator;

public record CollaboratorResponse(
        Integer id,
        String firstName,
        String lastName,
        String email
) {}
