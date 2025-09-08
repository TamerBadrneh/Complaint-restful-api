package org.selflearning.complaint_api.services;

import java.util.List;

import org.selflearning.complaint_api.models.Complaint;

public interface IComplaintService {

    List<Complaint> getAllComplaints(String status, String category);

    Complaint getComplaint(String id);

}
