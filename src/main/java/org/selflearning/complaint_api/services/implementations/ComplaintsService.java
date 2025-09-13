package org.selflearning.complaint_api.services.implementations;

import lombok.AllArgsConstructor;
import org.selflearning.complaint_api.models.Complaint;
import org.selflearning.complaint_api.repositories.ComplaintsRepository;
import org.selflearning.complaint_api.services.interfaces.IComplaintService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ComplaintsService implements IComplaintService {

    private ComplaintsRepository repositoryLayer;

    @Override
    public Iterable<Complaint> getAll() {
        return repositoryLayer.findAll();
    }

    @Override
    public Optional<Complaint> getComplaint(Long complaintId) {
        if(complaintId == null || complaintId <= 0)
            throw new IllegalArgumentException("The provided id is invalid, given: " + complaintId);
        return repositoryLayer.findById(complaintId);
    }

    @Override
    public Complaint saveComplaint(Complaint complaint) {
        if(complaint == null)
            throw new IllegalArgumentException("Complaints can't have a value of null");
        return repositoryLayer.save(complaint);
    }

    @Override
    public Complaint updateComplaint(Long complaintId, Complaint complaint) {
        if(complaintId == null || complaintId <= 0)
            throw new IllegalArgumentException("The provided id is invalid, given: " + complaintId);

        if(complaint == null)
            throw new IllegalArgumentException("Complaints can't have a value of null");

        Optional<Complaint> target = repositoryLayer.findById(complaintId);

        if(target.isEmpty())
            throw new NoSuchElementException("Complaint with id of " + complaintId + " not found");

        complaint.setId(complaintId);
        complaint.setUpdatedAt(LocalDate.now());

        return repositoryLayer.save(complaint);
    }

    @Override
    public void deleteComplaint(Long complaintId) {
        if(complaintId == null || complaintId <= 0)
            throw new IllegalArgumentException("The provided id is invalid, given: " + complaintId);

        Optional<Complaint> target = repositoryLayer.findById(complaintId);

        if(target.isEmpty())
            throw new NoSuchElementException("Complaint with id of " + complaintId + " not found");

        repositoryLayer.deleteById(complaintId);
    }
}
