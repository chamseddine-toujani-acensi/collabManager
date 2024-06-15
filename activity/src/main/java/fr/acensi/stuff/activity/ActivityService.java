package fr.acensi.stuff.activity;

import fr.acensi.stuff.collaborator.CollaboratorClient;
import fr.acensi.stuff.customer.CustomerClient;
import fr.acensi.stuff.employee.EmployeeClient;
import fr.acensi.stuff.exception.ActivityNotFoundException;
import fr.acensi.stuff.exception.BusinessException;
import fr.acensi.stuff.mission.MissionClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final CustomerClient customerClient;

    private final MissionClient missionClient;

    private final CollaboratorClient collaboratorClient;

    private final EmployeeClient employeeClient;

    private final ActivityRepository repository;

    private final ActivityMapper mapper;


    public Integer createActivity(ActivityRequest request) {
        // check customer
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException(String.format("Customer not found with id %s",request.customerId())));

        // check mission
        var mission = missionClient.findMissionById(request.missionId())
                .orElseThrow(() -> new BusinessException(String.format("Mission not found with id %s",request.customerId())));

        // collaborator check
        var collaborator = collaboratorClient.findCollaboratorById(request.collaboratorId())
                .orElseThrow(() -> new BusinessException(String.format("Collaborator not found with id %s",request.customerId())));

        // Employee check
        var employee = employeeClient.findEmployeeById(request.employeeId())
                .orElseThrow(() -> new BusinessException(String.format("Employee not found with id %s",request.customerId())));

        // persist activity
        var activity = Activity.builder()
                .reference(request.reference())
                .description(request.description())
                .paymentMethod(paymentMethod.valueOf(request.paymentMethod()))
                .customerId(customer.id())
                .missionId(mission.id())
                .EmployeeId(employee.id())
                .build();
        Activity savedActivity = repository.save(activity);

        return savedActivity.getId();
    }

    public List<ActivityResponse> getAllActivities() {
        return repository.findAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public ActivityResponse findById(Integer activityId) {
        return repository.findById(activityId)
                .map(mapper::toResponse)
                .orElseThrow(() ->new ActivityNotFoundException(""));
    }
}
