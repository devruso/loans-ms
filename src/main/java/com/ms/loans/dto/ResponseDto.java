package com.ms.loans.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto {

    private String HttpCode;
    private String responseMessage;

}
