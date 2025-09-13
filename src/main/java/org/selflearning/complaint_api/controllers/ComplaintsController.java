package org.selflearning.complaint_api.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.selflearning.complaint_api.constants.endpoints.ComplaintsEndPoints;
import org.selflearning.complaint_api.models.Complaint;
import org.selflearning.complaint_api.services.interfaces.IComplaintService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping(ComplaintsEndPoints.REQUEST_MAPPING)
@AllArgsConstructor
public class ComplaintsController {

    private IComplaintService serviceLayer;

    @GetMapping("")
    public ResponseEntity<Iterable<Complaint>> getAllComplaints() {
        return new ResponseEntity<>(serviceLayer.getAll() ,HttpStatus.OK);
    }

    @GetMapping(ComplaintsEndPoints.ID_PATH_VARIABLE)
    public ResponseEntity<Complaint> getComplaintById(@PathVariable final Long id) {
        if(id == null || id <= 0)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<Complaint> targetComplaint = serviceLayer.getComplaint(id);
        return targetComplaint.map(complaint -> new ResponseEntity<>(complaint, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PostMapping("")
    public ResponseEntity<Complaint> saveComplaint(@Valid @RequestBody final Complaint complaint) {
        if(complaint == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(serviceLayer.saveComplaint(complaint), HttpStatus.CREATED);
    }

    @PutMapping(ComplaintsEndPoints.UPDATE + "/" + ComplaintsEndPoints.ID_PATH_VARIABLE)
    public ResponseEntity<Complaint> updateComplaint(@PathVariable final Long id, @Valid @RequestBody final Complaint newComplaint) {
        if(id == null || id <= 0)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if(newComplaint == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(serviceLayer.updateComplaint(id, newComplaint), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(ComplaintsEndPoints.DELETE + "/" + ComplaintsEndPoints.ID_PATH_VARIABLE)
    public ResponseEntity<HttpStatus> deleteComplaint(@PathVariable final Long id) {
        if(id == null || id <= 0)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        serviceLayer.deleteComplaint(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
