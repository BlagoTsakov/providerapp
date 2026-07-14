package com.example.providerapp.exception;

import com.example.providerapp.model.response.ResponseErrorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public List<ResponseErrorDTO> alreadyExists(EntityAlreadyExistsException e) {
        return List.of(ResponseErrorDTO.builder()
                .message(e.getMessage())
                .type("ObjectConflict")
                .build());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public List<ResponseErrorDTO> notFound(EntityNotFoundException e) {
        return List.of(ResponseErrorDTO.builder()
                .message(e.getMessage())
                .type("ObjectNotFound")
                .build());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ResponseErrorDTO> validationFailed(MethodArgumentNotValidException e) {
        return e.getBindingResult().getFieldErrors().stream()
                .map(fieldError -> ResponseErrorDTO.builder()
                        .message(fieldError.getDefaultMessage())
                        .type("ValidationFailure")
                        .path(fieldError.getField())
                        .invalidValue(fieldError.getRejectedValue())
                        .build())
                .toList();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public List<ResponseErrorDTO> unexpected(Exception e) {
        log.error("Unexpected error", e);
        return List.of(ResponseErrorDTO.builder()
                .message("Internal server error")
                .type("GeneralError")
                .build());
    }
}
