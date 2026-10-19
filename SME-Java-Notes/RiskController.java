package com.fraudengineservice.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// Receives one payment as JSON
@RestController
public class RiskController {

    // POST /transactions
    @PostMapping("/transactions")
    public TransactionDto receive(@RequestBody TransactionDto payment) {
        // Echo it back for now
        return payment;
    }
}