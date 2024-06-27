package fr.acensi.activity.mission;

public record MissionResponse(
        String id,
        String title,
        String description,
        String startDate,
        String endDate,
        String category
) {
}
