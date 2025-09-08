package org.selflearning.complaint_api;

import org.selflearning.complaint_api.exceptions.ComplaintNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ ComplaintNotFoundException.class })
    public ResponseEntity<String> handleNotFoundComplaint(ComplaintNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ HttpMessageNotReadableException.class })
    public ResponseEntity<String> handleHttpMessageNotReadable(HttpMessageNotReadableException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ MethodArgumentNotValidException.class })
    public ResponseEntity<String> handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();

        String errors = bindingResult.getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .reduce("", (msg1, msg2) -> msg1 + msg2 + "\n");

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
