package com.ms.loans.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;


@Data
public class LoanDto {

    @NotNull
    private String mobileNumber;

    @NotNull
    private String loanNumber;

    @NotNull
    private String loanType;

    @NotNull
    private int totalLoan;

    @PositiveOrZero
    private int outstandingAmount = 0;

}
