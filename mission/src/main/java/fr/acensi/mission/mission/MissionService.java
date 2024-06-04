package fr.acensi.mission.mission;


import fr.acensi.mission.exception.MissionNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MissionService {

    private final MissionRepository repository;
    private final MissionMapper mapper;

    public Integer createMission(MissionRequest request) {
        var mission = mapper.toMission(request);
        return repository.save(mission).getId();
    }

    public List<MissionResponse> getAllMissions() {
        return repository.findAll().stream().map(mapper::toResponse).collect(Collectors.toList());
    }

    public MissionResponse findById(Integer missionId) {
        return repository.findById(missionId).map(mapper::toResponse).orElseThrow(() -> new MissionNotFoundException(String.format("Mission with id %s not found", missionId)));
    }
}
