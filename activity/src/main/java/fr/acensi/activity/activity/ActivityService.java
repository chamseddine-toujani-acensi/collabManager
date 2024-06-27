package fr.acensi.activity.activity;

import fr.acensi.activity.exception.ActivityNotFoundException;
import fr.acensi.activity.collaborator.CollaboratorClient;
import fr.acensi.activity.customer.CustomerClient;
import fr.acensi.activity.employee.EmployeeClient;
import fr.acensi.activity.exception.BusinessException;
import fr.acensi.activity.mission.MissionClient;
import fr.acensi.activity.payment.PaymentClient;
import fr.acensi.activity.payment.PaymentRequest;
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

    private final ActivityProducer activityProducer;

    private final PaymentClient paymentClient;

    private final ActivityMapper mapper;


    public Integer createActivity(ActivityRequest request) {
        // check customer
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException(String.format("Customer not found with id %s", request.customerId())));

        // check mission
        var mission = missionClient.findMissionById(request.missionId())
                .orElseThrow(() -> new BusinessException(String.format("Mission not found with id %s", request.customerId())));

        // collaborator check
        var collaborator = collaboratorClient.findCollaboratorById(request.collaboratorId())
                .orElseThrow(() -> new BusinessException(String.format("Collaborator not found with id %s", request.customerId())));

        // Employee check
        var employee = employeeClient.findEmployeeById(request.employeeId())
                .orElseThrow(() -> new BusinessException(String.format("Employee not found with id %s", request.customerId())));

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

        // payment notification
        var paymentRequest = new PaymentRequest(
                request.amount(),
                request.paymentMethod(),
                mapper.toResponse(activity),
                customer,
                mission,
                collaborator,
                employee
        );
        paymentClient.requestActivityPayment(paymentRequest);

        // Send order confirmation
        activityProducer.sendActivityConfirmation(new ActivityConfirmation(
                request.reference(),
                request.customerId(),
                request.missionId(),
                request.collaboratorId(),
                request.employeeId()));


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
                .orElseThrow(() -> new ActivityNotFoundException(String.format("Activity not found wit id %d",activityId)));
    }
}
