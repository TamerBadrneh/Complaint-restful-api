package org.selflearning.complaint_api.services;

import java.util.ArrayList;
import java.util.List;

import org.selflearning.complaint_api.constants.SystemValues;
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
        Integer index = getComplaintIndex(id);

        if (index == null || index.equals(SystemValues.NOT_FOUND))
            return null;

        return repository.getComplaint(index);
    }

    @Override
    public void createComplaint(final Complaint complaint) {
        repository.saveComplaint(complaint);
    }

    @Override
    public void updateComplaint(final String id, final Complaint newComplaint) {
        repository.updateComplaint(getComplaintIndex(id), newComplaint);
    }

    @Override
    public void deleteComplaint(final String id) {
        repository.deleteComplaint(getComplaintIndex(id));
    }

    // Business Logic
    private Integer getComplaintIndex(final String complaintId) {
        final List<Complaint> ALL_COMPLAINTS = getAllComplaints("all", "all");
        for (int index = 0; index < ALL_COMPLAINTS.size(); index++)
            if (ALL_COMPLAINTS.get(index).getId().equals(complaintId))
                return index;
        return SystemValues.NOT_FOUND;
    }

    private static List<Complaint> filterComplaintsByStatus(final List<Complaint> complaints, final String status) {
        if (status.equalsIgnoreCase("all"))
            return complaints;

        List<Complaint> result = new ArrayList<>();
        for (final Complaint complaint : complaints)
            if (complaint.getStatus().toString().equalsIgnoreCase(status))
                result.add(complaint);

        return result;
    }

    private static List<Complaint> filterComplaintsByCategory(final List<Complaint> complaints, final String category) {
        if (category.equalsIgnoreCase("all"))
            return complaints;

        List<Complaint> result = new ArrayList<>();
        for (final Complaint complaint : complaints)
            if (complaint.getCategory().toString().equalsIgnoreCase(category))
                result.add(complaint);

        return result;
    }
}
