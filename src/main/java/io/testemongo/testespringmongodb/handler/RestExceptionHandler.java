package io.testemongo.testespringmongodb.handler;

import io.testemongo.testespringmongodb.exception.badrequest.BadRequestException;
import io.testemongo.testespringmongodb.exception.notfound.ObjectNotFoundException;
import io.testemongo.testespringmongodb.exception.notfound.ObjectNotFoundExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ObjectNotFoundExceptionDetails> handleObjectNotFoundException(ObjectNotFoundException notFoundException) {
        ObjectNotFoundExceptionDetails errorDetails = ObjectNotFoundExceptionDetails.builder()
                .title("Object not found, check the documentation for more information")
                .status(404)
                .timestamp(LocalDateTime.now())
                .details(notFoundException.getMessage())
                .developerMessage(notFoundException.getClass().getName())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ObjectNotFoundExceptionDetails> handleBadRequestException(BadRequestException badRequestException) {
        ObjectNotFoundExceptionDetails errorDetails = ObjectNotFoundExceptionDetails.builder()
                .title("Bad request, check the documentation for more information")
                .status(400)
                .timestamp(LocalDateTime.now())
                .details(badRequestException.getMessage())
                .developerMessage(badRequestException.getClass().getName())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }
}
