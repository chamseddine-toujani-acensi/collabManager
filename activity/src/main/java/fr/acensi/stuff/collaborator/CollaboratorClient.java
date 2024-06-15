package fr.acensi.stuff.collaborator;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "collaborator-service",
        url = "${application.config.collaborator-url}"
)
public interface CollaboratorClient {

    @GetMapping("/collaborator-id")
    Optional<CollaboratorResponse> findCollaboratorById(@PathVariable("collaborator-id") String collaboratorId);
}
