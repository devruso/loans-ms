package com.ms.loans.controller;


import com.ms.loans.dto.LoanDto;
import com.ms.loans.dto.ResponseDto;
import com.ms.loans.service.ILoanService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/loan", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class LoanController {

    @Autowired
    private ILoanService loanService;


    @PostMapping()
    public ResponseEntity<ResponseDto> createLoan(LoanDto loanObject){
        loanService.createLoan(loanObject);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto("201", "Empréstimo criado"));
    }

    @GetMapping
    public ResponseEntity<ResponseDto> getLoans(){
        loanService.getLoans();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto("200","List"));
    }

    @PutMapping
    public ResponseEntity<ResponseDto> updateLoan(LoanDto updatableLoan){
        loanService.updateLoan(updatableLoan);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        new ResponseDto("200", "Loan Deleted successfully")
                );

    }


}
