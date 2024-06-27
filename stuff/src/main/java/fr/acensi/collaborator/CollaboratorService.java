package fr.acensi.collaborator;

import fr.acensi.exception.CollaboratorNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CollaboratorService {

    private final CollaboratorRepository repository;
    private final CollaboratorMapper mapper;

    public Integer createCollaborator(CollaboratorRequest request) {
        var collaborator = repository.save(mapper.toEntity(request));
        return collaborator.getId();
    }

    public void updateCollaborator(CollaboratorRequest request) {
        var collaborator = repository.findById(request.id())
                .orElseThrow(()-> new CollaboratorNotFoundException(format("Can not update collaborator with id : %s", request.id())));
        mergeCollaborator(collaborator,request);
        repository.save(collaborator);
    }

    private void mergeCollaborator(Collaborator collaborator, CollaboratorRequest request) {
        if(StringUtils.isNotBlank(request.firstName()))
            collaborator.setFirstName(request.firstName());
        if(StringUtils.isNotBlank(request.lastName()))
            collaborator.setFirstName(request.lastName());
        if(StringUtils.isNotBlank(request.email()))
            collaborator.setEmail(request.email());
        if(Objects.nonNull(request.address()))
            collaborator.setAddress(request.address());
    }

    public List<CollaboratorResponse> findAllCollaborators() {
        return repository.findAll()
                .stream()
                .map(mapper::fromCollaborator)
                .collect(Collectors.toList());
    }

    public Boolean existsById(Integer collaboratorId) {
        return repository.findById(collaboratorId).isPresent();
    }

    public CollaboratorResponse findById(Integer collaboratorId) {
        return repository.findById(collaboratorId)
                .map(mapper::fromCollaborator)
                .orElseThrow(() -> new CollaboratorNotFoundException(format("No collaborator found with provided id: %s", collaboratorId)));

    }

    public void deleteCollaborator(Integer collaboratorId) {
        repository.deleteById(collaboratorId);
    }
}
