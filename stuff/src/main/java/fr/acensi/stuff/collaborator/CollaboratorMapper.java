package fr.acensi.stuff.collaborator;


import org.springframework.stereotype.Service;

@Service
public class CollaboratorMapper {
    public Collaborator toEntity(CollaboratorRequest request) {
        return Collaborator.builder()
                .id(request.id())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .phone(request.phone())
                .address(request.address())
                .city(request.city())
                .state(request.state())
                .country(request.country())
                .zip(request.zip())
                .build();
    }

    public CollaboratorResponse fromCollaborator(Collaborator collaborator) {
        return new CollaboratorResponse(collaborator.getId(), collaborator.getFirstName(), collaborator.getLastName(), collaborator.getEmail());
    }
}
