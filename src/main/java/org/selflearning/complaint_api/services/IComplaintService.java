package org.selflearning.complaint_api.services;

import java.util.List;

import org.selflearning.complaint_api.models.Complaint;

public interface IComplaintService {

    List<Complaint> getAllComplaints(String status, String category);

    Complaint getComplaint(String id);

    void createComplaint(Complaint complaint);

    void updateComplaint(String id, Complaint newComplaint);

    void deleteComplaint(String id);

}
