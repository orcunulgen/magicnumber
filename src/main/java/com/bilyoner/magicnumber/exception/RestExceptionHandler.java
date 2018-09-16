package com.bilyoner.magicnumber.exception;

import com.mongodb.MongoWriteException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {
    private static final Integer DUBLICATE_KEY_CODE = 11000;

    @ExceptionHandler(MongoWriteException.class)
    public ResponseEntity<BaseResponse> handleDublicateKeyError(MongoWriteException e) {
        if (e.getCode() == DUBLICATE_KEY_CODE)
            return new ResponseEntity<>(new BaseResponse(ResponseCode.DUBLICATE_KEY.toString(), e.toString()), HttpStatus.BAD_REQUEST);
        else
            return handleError(e);
    }

    public ResponseEntity<BaseResponse> handleError(Exception e) {
        return new ResponseEntity<>(new BaseResponse(ResponseCode.SERVER_ERROR.toString(), e.toString()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}