package org.selflearning.complaint_api.repositories;

import org.selflearning.complaint_api.models.Complaint;
import org.springframework.data.repository.CrudRepository;

public interface ComplaintsRepository extends CrudRepository<Complaint, Long> {

}
