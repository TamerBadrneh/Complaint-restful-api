package org.selflearning.complaint_api.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;
import org.selflearning.complaint_api.constants.SystemValues;
import org.selflearning.complaint_api.exceptions.ComplaintNotFoundException;
import org.selflearning.complaint_api.models.Complaint;
import org.selflearning.complaint_api.repositories.ComplaintsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComplaintsService implements IComplaintService {

    @Autowired
    private ComplaintsRepository repository;

    // Service Methods - CRUD
    @Override
    public List<Complaint> getAllComplaints(String status, String category) {
        List<Complaint> allComplaints = repository.getAllComplaints();
        allComplaints = filterComplaintsByStatus(allComplaints, status);
        allComplaints = filterComplaintsByCategory(allComplaints, category);
        return allComplaints;
    }

    @Override
    public Complaint getComplaint(String id) {
        return repository.getComplaint(getComplaintIndex(id));
    }

    @Override
    public void createComplaint(final Complaint complaint) {
        repository.saveComplaint(complaint);
    }

    @Override
    public void updateComplaint(final String id, final Complaint newComplaint) {
        newComplaint.setUpdatedAt(LocalDateTime.now());
        repository.updateComplaint(getComplaintIndex(id), newComplaint);
    }

    @Override
    public void deleteComplaint(final String id) {
        repository.deleteComplaint(getComplaintIndex(id));
    }

    // Business Logic
    private Integer getComplaintIndex(final String complaintId) {
        final List<Complaint> ALL_COMPLAINTS = getAllComplaints(SystemValues.ALL, SystemValues.ALL);
        return IntStream.range(0, ALL_COMPLAINTS.size())
                .filter(index -> ALL_COMPLAINTS.get(index).getId().equals(complaintId))
                .findFirst()
                .orElseThrow(() -> new ComplaintNotFoundException(
                        new StringBuilder("Id: ").append(complaintId).append(" not found.").toString()));
    }

    private static List<Complaint> filterComplaintsByStatus(final List<Complaint> complaints, final String status) {
        if (status.equalsIgnoreCase(SystemValues.ALL))
            return complaints;
        return complaints.stream()
                .filter((Complaint complaint) -> complaint.getStatus().toString().equalsIgnoreCase(status))
                .toList();
    }

    private static List<Complaint> filterComplaintsByCategory(final List<Complaint> complaints, final String category) {
        if (category.equalsIgnoreCase("all"))
            return complaints;

        return complaints.stream()
                .filter((Complaint complaint) -> complaint.getCategory().toString().equalsIgnoreCase(category))
                .toList();
    }
}
