package org.selflearning.complaint_api.repositories;

import org.selflearning.complaint_api.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
