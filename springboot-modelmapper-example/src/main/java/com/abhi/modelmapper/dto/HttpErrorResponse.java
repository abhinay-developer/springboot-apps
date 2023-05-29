package com.abhi.modelmapper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HttpErrorResponse {
    private int statusCode;
    private String status;
    private String message;
    private Date date;
}
