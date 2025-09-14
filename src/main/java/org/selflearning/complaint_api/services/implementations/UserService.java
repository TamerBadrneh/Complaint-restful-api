package org.selflearning.complaint_api.services.implementations;

import lombok.AllArgsConstructor;
import org.selflearning.complaint_api.models.User;
import org.selflearning.complaint_api.repositories.UserRepository;
import org.selflearning.complaint_api.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    // @Autowired
    private UserRepository repositoryLayer;

    @Override
    public Iterable<User> getAll() {
        return repositoryLayer.findAll();
    }

    @Override
    public Optional<User> getUser(Long userId) {
        if(userId == null || userId <= 0)
            throw new IllegalArgumentException("Invalid user id, given: " + userId);
        return repositoryLayer.findById(userId);
    }

    @Override
    public User saveUser(User user) {
        if(user == null)
            throw new IllegalArgumentException("Can't save a null user");
        return repositoryLayer.save(user);
    }

    @Override
    public User updateUser(Long userId, User user) {
        if(userId == null || userId <= 0)
            throw new IllegalArgumentException("Invalid user id, given: " + userId);

        if(user == null)
            throw new IllegalArgumentException("Can't save a null user");

        Optional<User> target = getUser(userId);

        if(target.isEmpty())
            throw new NoSuchElementException("User with id: " + userId + " doesn't exist");

        user.setId(target.get().getId());
        return repositoryLayer.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        if(userId == null || userId <= 0)
            throw new IllegalArgumentException("Invalid user id, given: " + userId);
        repositoryLayer.deleteById(userId);
    }
}
