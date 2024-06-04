package fr.acensi.mission.mission;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService service;


    @PostMapping
    public ResponseEntity<Integer> createMission(@RequestBody @Valid MissionRequest request) {
        return ResponseEntity.ok(service.createMission(request));
    }

    @GetMapping
    public ResponseEntity<List<MissionResponse>> getAllMissions() {
        return ResponseEntity.ok(service.getAllMissions());
    }

    @GetMapping("/{mission-id}")
    public ResponseEntity<MissionResponse> getMissionById(@PathVariable("mission-id") Integer missionId) {
        return ResponseEntity.ok(service.findById(missionId));
    }
}
