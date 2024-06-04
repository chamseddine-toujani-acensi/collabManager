package fr.acensi.stuff.activity;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    public Integer createActivity(ActivityRequest request) {
        // check customer

        // check mission

        // collaborator check

        // persist activity

        return null;
    }

    public List<ActivityResponse> getAllActivities() {
        return null;
    }

    public ActivityResponse findById(Integer activityId) {
        return null;
    }
}
