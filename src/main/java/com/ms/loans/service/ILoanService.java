package com.ms.loans.service;


import com.ms.loans.dto.LoanDto;
import com.ms.loans.entity.Loan;

import java.util.List;
import java.util.UUID;

public interface ILoanService {

    Loan createLoan(LoanDto loanTransferObject);

    List<LoanDto> getLoans();

    boolean updateLoan(LoanDto loan);

    boolean deleteLoan(LoanDto loan);

}
