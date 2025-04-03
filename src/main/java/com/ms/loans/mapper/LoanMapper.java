package com.ms.loans.mapper;

import com.ms.loans.dto.LoanDto;
import com.ms.loans.entity.Loan;

public class LoanMapper {

    public static Loan DtoToEntity(LoanDto loanDto, Loan newLoan){
        newLoan.setLoanType(loanDto.getLoanType());
        newLoan.setLoanNumber(loanDto.getLoanNumber());
        newLoan.setTotalLoan(loanDto.getTotalLoan());
        newLoan.setMobileNumber(loanDto.getMobileNumber());
        newLoan.setOutstandingAmount(loanDto.getOutstandingAmount());
        return newLoan;
    }

    public static LoanDto EntityToDto(Loan loan, LoanDto newLoanDto){
        newLoanDto.setLoanType(loan.getLoanType());
        newLoanDto.setLoanNumber(loan.getLoanNumber());
        newLoanDto.setMobileNumber(loan.getMobileNumber());
        newLoanDto.setTotalLoan(loan.getTotalLoan());
        newLoanDto.setOutstandingAmount(loan.getOutstandingAmount());
        return newLoanDto;
    }

}
