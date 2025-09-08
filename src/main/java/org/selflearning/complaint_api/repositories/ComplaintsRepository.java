package org.selflearning.complaint_api.repositories;

import java.util.ArrayList;
import java.util.List;
import org.selflearning.complaint_api.models.Complaint;
import org.springframework.stereotype.Repository;

@Repository
public class ComplaintsRepository {

    private final List<Complaint> dataStore = new ArrayList<>();

    public List<Complaint> getAllComplaints() {
        return new ArrayList<>(dataStore);
    }

    public Complaint getComplaint(final Integer index) {
        return dataStore.get(index);
    }

    public void saveComplaint(final Complaint object) {
        dataStore.add(object);
    }

    public void updateComplaint(final int index, final Complaint newComplaint) {
        dataStore.set(index, newComplaint);
    }

    public void deleteComplaint(final int index) {
        dataStore.remove(index);
    }
}
