package org.selflearning.complaint_api.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.selflearning.complaint_api.constants.endpoints.UsersEndPoints;
import org.selflearning.complaint_api.models.User;
import org.selflearning.complaint_api.services.interfaces.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(UsersEndPoints.REQUEST_MAPPING)
@AllArgsConstructor
public class UsersController {

    private IUserService serviceLayer;

    @GetMapping("")
    public ResponseEntity<Iterable<User>> getAll() {
        return new ResponseEntity<>(serviceLayer.getAll(), HttpStatus.OK);
    }

    @GetMapping(UsersEndPoints.ID_PATH_VARIABLE)
    public ResponseEntity<User> getUserById(@PathVariable final Long id) {
        if(id == null || id <= 0)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Optional<User> target =  serviceLayer.getUser(id);

        return target.map(user -> new ResponseEntity<>(user, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PostMapping("")
    public ResponseEntity<User> saveUser(@Valid @RequestBody final User user) {
        if(user == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(serviceLayer.saveUser(user), HttpStatus.CREATED);
    }

    @PutMapping(UsersEndPoints.UPDATE + "/" + UsersEndPoints.ID_PATH_VARIABLE)
    public ResponseEntity<User> updateUser(@PathVariable final Long id, @Valid @RequestBody final User user) {
        if(id == null || id <= 0)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if(user == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(serviceLayer.updateUser(id, user), HttpStatus.OK);
    }

    @DeleteMapping(UsersEndPoints.DELETE + "/" + UsersEndPoints.ID_PATH_VARIABLE)
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable final Long id) {
        if(id == null || id <= 0)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        serviceLayer.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
