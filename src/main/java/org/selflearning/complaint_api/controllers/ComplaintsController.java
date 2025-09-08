package org.selflearning.complaint_api.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.selflearning.complaint_api.constants.Endpoints;
import org.selflearning.complaint_api.models.Complaint;
import org.selflearning.complaint_api.services.IComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(Endpoints.COMPLAINTS_REQUEST_MAPPING)
public class ComplaintsController {

    @Autowired
    private IComplaintService service;

    @GetMapping("")
    public ResponseEntity<Complaint> getComplaint(@RequestParam final String id) {
        return new ResponseEntity<>(service.getComplaint(id), HttpStatus.OK);
    }

    @GetMapping(Endpoints.ALL)
    public ResponseEntity<List<Complaint>> getAll(
            @RequestParam(required = false, defaultValue = "all") final String status,
            @RequestParam(required = false, defaultValue = "all") final String category) {
        return new ResponseEntity<>(service.getAllComplaints(status, category), HttpStatus.OK);
    }

}
