package fr.acensi.collaborator;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/stuff/collaborators")
@RequiredArgsConstructor
public class CollaboratorController {

    private CollaboratorService service;


    @PostMapping
    public ResponseEntity<Integer> createCollaborator(@RequestBody @Valid CollaboratorRequest request) {
        return ResponseEntity.ok(service.createCollaborator(request));
    }

    @PutMapping
    public ResponseEntity<Void> updateCollaborator(@RequestBody @Valid CollaboratorRequest request) {
        service.updateCollaborator(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    public ResponseEntity<List<CollaboratorResponse>> findAll() {
        return ResponseEntity.ok(service.findAllCollaborators());
    }

    @GetMapping("/exists/{collaborator-id}")
    public ResponseEntity<Boolean> existsById(@PathVariable("collaborator-id") Integer collaboratorId) {
        return ResponseEntity.ok(service.existsById(collaboratorId));
    }

    @GetMapping("/{collaborator-id}")
    public ResponseEntity<CollaboratorResponse> findById(@PathVariable("collaborator-id") Integer collaboratorId) {
        return ResponseEntity.ok(service.findById(collaboratorId));
    }

    @DeleteMapping("/{collaborator-id}")
    public ResponseEntity<Void> deleteCollaborator(@PathVariable("collaborator-id") Integer collaboratorId) {
        service.deleteCollaborator(collaboratorId);
        return ResponseEntity.accepted().build();
    }

}
