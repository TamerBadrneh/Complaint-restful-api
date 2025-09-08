package org.selflearning.complaint_api.exceptions;

public class ComplaintNotFoundException extends RuntimeException {

    public ComplaintNotFoundException(final String message) {
        super(message);
    }

}
