package com.ms.loans.repository;

import com.ms.loans.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LoanRepository extends JpaRepository<Loan, UUID> {

    Optional<Loan> findByMobileNumber(String mobileNumber);
}
