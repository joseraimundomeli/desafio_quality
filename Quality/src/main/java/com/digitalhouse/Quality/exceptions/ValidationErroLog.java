package com.digitalhouse.Quality.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ValidationErroLog {
    private String fild;
    private String message;
}
