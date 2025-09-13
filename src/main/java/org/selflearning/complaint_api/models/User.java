package org.selflearning.complaint_api.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class User {

    private String id;
    private String name;
    private LocalDate dateOfCreation;
    private String email;
    private String password;

}
