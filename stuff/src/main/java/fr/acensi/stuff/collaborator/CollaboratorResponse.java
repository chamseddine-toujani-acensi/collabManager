package fr.acensi.stuff.collaborator;

public record CollaboratorResponse(
        Integer id,
        String firstName,
        String lastName,
        String email
) {}
