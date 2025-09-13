package org.selflearning.complaint_api.services.interfaces;

import org.selflearning.complaint_api.models.Complaint;

import java.util.Optional;

public interface IComplaintService {
    Iterable<Complaint> getAll();
    Optional<Complaint> getComplaint(final Long complaintId);
    Complaint saveComplaint(final Complaint complaint);
    Complaint updateComplaint(final Long complaintId, final Complaint complaint);
    void deleteComplaint(final Long complaintId);
}
