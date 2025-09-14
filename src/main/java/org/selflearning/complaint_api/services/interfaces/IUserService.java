package org.selflearning.complaint_api.services.interfaces;

import org.selflearning.complaint_api.models.User;

import java.util.Optional;

public interface IUserService {
    Iterable<User> getAll();
    Optional<User> getUser(final Long userId);
    User saveUser(final User user);
    User updateUser(final Long userId, final User user);
    void deleteUser(final Long userId);
}
