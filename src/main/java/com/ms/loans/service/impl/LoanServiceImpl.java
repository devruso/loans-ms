package com.ms.loans.service.impl;

import com.ms.loans.dto.LoanDto;
import com.ms.loans.entity.Loan;
import com.ms.loans.exception.LoanAlreadyExistsException;
import com.ms.loans.exception.ResourceNotFoundException;
import com.ms.loans.mapper.LoanMapper;
import com.ms.loans.repository.LoanRepository;
import com.ms.loans.service.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;


@Repository
public class LoanServiceImpl implements ILoanService {


    @Autowired
    private LoanRepository loanRepository;

    @Override
    public Loan createLoan(LoanDto loanObject){
        loanRepository
                .findByMobileNumber(loanObject.getMobileNumber())
                .orElseThrow(
                        () -> new LoanAlreadyExistsException("This mobile number already is already registered.")
                );

        Loan createdLoan = LoanMapper.DtoToEntity(loanObject, new Loan());

        loanRepository.save(createdLoan);

        return createdLoan;
    }

    @Override
    public List<LoanDto> getLoans(){
        List<Loan> loanList = loanRepository.findAll();
        return loanList.stream()
                .map(el -> LoanMapper.EntityToDto(el, new LoanDto()))
                .collect(Collectors.toList());
    }


    @Override
    public boolean updateLoan(LoanDto loan){
        Loan existingLoan = loanRepository.
                            findByMobileNumber(loan.getMobileNumber())
                            .orElseThrow(
                                    ()-> new ResourceNotFoundException("Loan", "mobile number: ", loan.getMobileNumber())
                            );
        LoanMapper.DtoToEntity(loan, existingLoan);
        loanRepository.save(existingLoan);
        return true;
    }

    @Override
    public boolean deleteLoan(LoanDto loan) {
        Loan foundLoan =
                loanRepository
                .findByMobileNumber(loan.getMobileNumber())
                        .orElseThrow(
                                () -> new ResourceNotFoundException("loan", "mobile number: ", loan.getMobileNumber())
                        );
        loanRepository.deleteById(foundLoan.getId());
        return true;
    }


}
