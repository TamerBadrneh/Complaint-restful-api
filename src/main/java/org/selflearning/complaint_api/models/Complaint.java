package org.selflearning.complaint_api.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.selflearning.complaint_api.constants.ComplaintCategory;
import org.selflearning.complaint_api.constants.ComplaintResolveStatus;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "COMPLAINTS")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE", nullable = false)
    @NotBlank(message = "Title can't be blank")
    @Length(min = 3, max = 50, message = "Complaint Title Should Be Between [3 - 50] Characters.")
    private String title;

    @Column(name = "DESCRIPTION", nullable = false)
    @Length(max = 200, message = "Complaint Description Does not Exceed 200 characters.")
    private String description;

    @Column(name = "CATEGORY", nullable = false)
    @NotBlank(message = "Category can't be blank")
    private ComplaintCategory category;

    @Column(name = "STATUS", nullable = false)
    private ComplaintResolveStatus status;

    @Column(name = "CREATED_AT", updatable = false, insertable = false)
    private LocalDate createdAt;

    @Column(name = "UPDATED_AT", insertable = false)
    private LocalDate updatedAt;

    public Complaint() {
        this.setCreatedAt(LocalDate.now());
    }
}
