package org.selflearning.complaint_api.repositories;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.selflearning.complaint_api.constants.ComplaintCategory;
import org.selflearning.complaint_api.constants.ComplaintResolveStatus;
import org.selflearning.complaint_api.models.Complaint;
import org.springframework.stereotype.Repository;

@Repository
public class ComplaintsRepository {

    private final List<Complaint> dataStore = Arrays.asList(
            new Complaint("123", "Service Closed", "Closed when paying for product", ComplaintCategory.SERVICE,
                    ComplaintResolveStatus.CLOSED, LocalDateTime.now(), null),
            new Complaint("234", "Service Down", "Server shuts down", ComplaintCategory.SERVICE,
                    ComplaintResolveStatus.OPENED, LocalDateTime.now(), null),
            new Complaint("345", "Product Not like expected", "product...", ComplaintCategory.PRODUCT,
                    ComplaintResolveStatus.OPENED, LocalDateTime.now(), null),
            new Complaint("456", "Product Not Valid", "product...", ComplaintCategory.PRODUCT,
                    ComplaintResolveStatus.IN_SERVICE, LocalDateTime.now(), null),
            new Complaint("567", "Staff was not nice", "staff...", ComplaintCategory.STAFF,
                    ComplaintResolveStatus.CLOSED, LocalDateTime.now(), null),
            new Complaint("678", "Staff was not ok at work", "staff...", ComplaintCategory.STAFF,
                    ComplaintResolveStatus.IN_SERVICE, LocalDateTime.now(), null));

    public List<Complaint> getAllComplaints() {
        return new ArrayList<>(dataStore);
    }

    public Complaint geComplaint(final Integer index) {
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
