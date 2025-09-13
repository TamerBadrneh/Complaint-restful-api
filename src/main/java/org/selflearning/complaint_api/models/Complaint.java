package org.selflearning.complaint_api.models;


import lombok.Getter;
import lombok.Setter;
import org.selflearning.complaint_api.constants.ComplaintCategory;
import org.selflearning.complaint_api.constants.ComplaintResolveStatus;
import java.time.LocalDate;

@Getter
@Setter
public class Complaint {

    private String id;
    private String title;
    private String description;
    private ComplaintCategory category;
    private ComplaintResolveStatus status;
    private LocalDate createdAt;
    private LocalDate updatedAt;

}
