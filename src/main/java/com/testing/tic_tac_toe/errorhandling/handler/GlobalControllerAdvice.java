package com.testing.tic_tac_toe.errorhandling.handler;

import com.testing.tic_tac_toe.domain.common.BaseResponse;
import com.testing.tic_tac_toe.errorhandling.exception.DataNotFoundException;
import com.testing.tic_tac_toe.errorhandling.exception.InvalidBodyException;
import com.testing.tic_tac_toe.mapper.ResponseMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@Log4j2
@RestControllerAdvice
public class GlobalControllerAdvice {

    //    COMMON ERROR
    @ExceptionHandler(DataNotFoundException.class)
    public Mono<ResponseEntity<BaseResponse<Object>>> handle(DataNotFoundException e) {
        return Mono.just(ResponseMapper.map(HttpStatus.BAD_REQUEST, e.getMessage(), null));
    }

    @ExceptionHandler(InvalidBodyException.class)
    public Mono<ResponseEntity<BaseResponse<Object>>> handle(InvalidBodyException e) {
        return Mono.just(ResponseMapper.map(HttpStatus.BAD_REQUEST, e.getMessage(), null));
    }

    //    UNEXPECTED/UNHANDLED ERROR
    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<BaseResponse<Object>>> handle(Exception e) {
        log.trace("Exception class : {}", e.getClass());
        log.trace("Unexpected error trace :", e);

        return Mono.just(ResponseMapper.map(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected error : " + e.getMessage(), null));
    }

}
