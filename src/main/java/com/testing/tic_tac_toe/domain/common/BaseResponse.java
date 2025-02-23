package com.testing.tic_tac_toe.domain.common;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BaseResponse<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = -5005297134702600556L;
    
    private LocalDateTime timestamp;
    private Integer code;
    private String message;
    private transient T data;

}
