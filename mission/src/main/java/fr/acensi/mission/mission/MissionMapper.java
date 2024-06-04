package fr.acensi.mission.mission;

import fr.acensi.mission.category.Category;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class MissionMapper {
    public Mission toMission(MissionRequest request) {
        return Mission.builder()
                .title(request.title())
                .description(request.description())
                .startDate(LocalDate.parse(request.startDate(), DateTimeFormatter.ISO_DATE))
                .endDate(LocalDate.parse(request.endDate(), DateTimeFormatter.ISO_DATE))
                .status(Status.valueOf(request.status()))
                .category(Category.builder().id(request.categoryId()).build())
                .tgm(request.tgm())
                .address(request.address())
                .phone(request.phone())
                .email(request.email())
                .build();
    }

    public MissionResponse toResponse(Mission mission) {
        return new MissionResponse(
                mission.getId(),
                mission.getTitle(),
                mission.getDescription(),
                mission.getStartDate().toString(),
                mission.getEndDate().toString(),
                mission.getStatus(),
                mission.getCategory().getName(),
                mission.getTgm(),
                mission.getAddress(),
                mission.getPhone(),
                mission.getEmail()
        );
    }
}
