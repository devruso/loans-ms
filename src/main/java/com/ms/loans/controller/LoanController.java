package com.ms.loans.controller;


import com.ms.loans.dto.LoanDto;
import com.ms.loans.dto.ResponseDto;
import com.ms.loans.entity.Loan;
import com.ms.loans.service.impl.LoanServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/loan", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class LoanController {

    @Autowired
    private LoanServiceImpl loanService;


    @PostMapping()
    public ResponseEntity<ResponseDto> createLoan(@RequestBody @Valid LoanDto loanObject){
        loanService.createLoan(loanObject);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto("201", "Empréstimo criado"));
    }

    @GetMapping
    public ResponseEntity<List<LoanDto>> getLoans(){
        return ResponseEntity.status(HttpStatus.OK).body(loanService.getLoans());
    }




    @PutMapping
    public ResponseEntity<ResponseDto> updateLoan(LoanDto updatableLoan){
        loanService.updateLoan(updatableLoan);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        new ResponseDto("200", "Loan updated successfully successfully")
                );

    }

    @GetMapping("/{mobileNumber}")
    public ResponseEntity<Loan> getLoanByMobileNumber(@PathVariable String mobileNumber){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        loanService.findLoanByMobileNumber(mobileNumber)
                );
    }

    @DeleteMapping
    public ResponseEntity<ResponseDto> deleteLoan(LoanDto deletableLoan){
        loanService.deleteLoan(deletableLoan);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto("200", "Loan deleted successfully"));
    }

}
