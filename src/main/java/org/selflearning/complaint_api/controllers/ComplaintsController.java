package org.selflearning.complaint_api.controllers;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import java.util.List;

import org.selflearning.complaint_api.constants.Endpoints;
import org.selflearning.complaint_api.models.Complaint;
import org.selflearning.complaint_api.services.IComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @PostMapping()
    public ResponseEntity<HttpStatus> createComplaint(@Valid @RequestBody final Complaint object) {
        service.createComplaint(object);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<HttpStatus> updateComplaint(@PathVariable final String id,
            @Valid @RequestBody final Complaint newComplaint) {
        service.updateComplaint(id, newComplaint);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteComplaint(@PathVariable final String id) {
        service.deleteComplaint(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
