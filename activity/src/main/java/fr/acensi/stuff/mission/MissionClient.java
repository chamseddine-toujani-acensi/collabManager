package fr.acensi.stuff.mission;

import fr.acensi.stuff.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MissionClient {

    @Value("${application.config.mission-url}")
    private String missionUrl;

    private final RestTemplate restTemplate;

    public final Optional<MissionResponse> findMissionById(String missionId){
        String url = String.format("%s/%d", missionUrl, missionId);
        ResponseEntity<MissionResponse> response = restTemplate.getForEntity(url, MissionResponse.class);
        if (response.getStatusCode().isError()) {
            throw new BusinessException(String.format("Error getting mission infos with id : %s", missionId));
        } else {
            return Optional.ofNullable(response.getBody());
        }
    }
}
