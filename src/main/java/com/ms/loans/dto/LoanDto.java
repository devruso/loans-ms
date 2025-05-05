package com.ms.loans.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;


@Data
public class LoanDto {

    @NotNull @NotBlank
    private String mobileNumber;

    @NotNull
    private String loanNumber;

    private String loanType;

    @Positive
    private int totalLoan;

    @PositiveOrZero
    private int amountPaid;

    private int outstandingAmount;

}
