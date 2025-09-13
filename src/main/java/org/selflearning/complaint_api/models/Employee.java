package org.selflearning.complaint_api.models;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

    private Long id;
    private String name;
    private LocalDate dateOfCreation;
    private String email;
    private String password;

}
