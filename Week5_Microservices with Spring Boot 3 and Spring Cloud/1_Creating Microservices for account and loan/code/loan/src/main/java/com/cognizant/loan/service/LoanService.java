package com.cognizant.loan.service;

import com.cognizant.loan.exception.LoanNotFoundException;
import com.cognizant.loan.model.Loan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    private final List<Loan> loans;

    public LoanService() {
        this.loans = List.of(
                new Loan("H00987987972342", "car", 400000, 3258, 18),
                new Loan("H009879872342", "bike", 200000, 1258, 10)
        );
    }

    public Loan getLoan(String loanNumber) {
        return loans.stream().filter(loan -> loan.getNumber().equals(loanNumber)).findFirst()
                .orElseThrow(() -> new LoanNotFoundException("Invalid loan " + loanNumber));
    }
}
