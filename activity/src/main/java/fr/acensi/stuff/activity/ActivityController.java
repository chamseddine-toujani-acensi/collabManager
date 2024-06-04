package fr.acensi.stuff.activity;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/activities")
@RequiredArgsConstructor
public class ActivityController {


    private final ActivityService service;


    @PostMapping
    public ResponseEntity<Integer> createActivity(@RequestBody @Valid ActivityRequest request) {
        return ResponseEntity.ok(service.createActivity(request));
    }

    @GetMapping
    public ResponseEntity<List<ActivityResponse>> getAllActivities() {
        return ResponseEntity.ok(service.getAllActivities());
    }

    @GetMapping("/{activity-id}")
    public ResponseEntity<ActivityResponse> getActivityById(@PathVariable("activity-id") Integer ActivityId) {
        return ResponseEntity.ok(service.findById(ActivityId));
    }
}
