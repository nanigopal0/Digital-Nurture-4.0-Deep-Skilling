package com.cognizant.loan.controller;

import com.cognizant.loan.exception.LoanNotFoundException;
import com.cognizant.loan.service.LoanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoanController.class);
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/loans/{number}")
    public Object getLoan(@PathVariable(name = "number") String loanNumber) {
        try {
            return loanService.getLoan(loanNumber);
        } catch (LoanNotFoundException e) {
            LOGGER.error("Loan not found: {}", e.getMessage());
            return "Loan not found: " + e.getMessage();
        } catch (RuntimeException e) {
            LOGGER.error("Error: {}", e.getMessage());
            return "Error: " + e.getMessage();
        }
    }
}
