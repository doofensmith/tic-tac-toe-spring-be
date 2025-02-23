package com.testing.tic_tac_toe.mapper;

import com.testing.tic_tac_toe.domain.common.BaseResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseMapper {

    public static <T> ResponseEntity<BaseResponse<T>> map(HttpStatus httpStatus, String message, T data) {
        return new ResponseEntity<>(
                new BaseResponse<>(LocalDateTime.now(), httpStatus.value(), message, data),
                httpStatus
        );
    }

    public static <T> ResponseEntity<BaseResponse<T>> map(HttpStatus httpStatus, T data) {
        return new ResponseEntity<>(
                new BaseResponse<>(LocalDateTime.now(), httpStatus.value(), httpStatus.getReasonPhrase(), data),
                httpStatus
        );
    }

}
