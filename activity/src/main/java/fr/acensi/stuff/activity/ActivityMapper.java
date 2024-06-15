package fr.acensi.stuff.activity;

import org.springframework.stereotype.Service;

@Service
public class ActivityMapper {
    public ActivityResponse toResponse(Activity activity) {
        return new ActivityResponse(
                activity.getId(),
                activity.getReference(),
                activity.getDescription(),
                activity.getPaymentMethod().name(),
                activity.getCustomerId(),
                activity.getMissionId(),
                activity.getCollaboratorId(),
                activity.getEmployeeId(),
                activity.getCreationDate().toString(),
                activity.getLastUpdateDate().toString()
        );
    }
}
