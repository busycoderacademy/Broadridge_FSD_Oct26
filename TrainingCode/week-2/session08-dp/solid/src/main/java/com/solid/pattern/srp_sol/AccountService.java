package com.solid.pattern.srp_sol;

public class AccountService {
    private LoggingService loggingService;
    private ReportingService reportingService;

    public AccountService(LoggingService loggingService, ReportingService reportingService) {
        this.loggingService = loggingService;
        this.reportingService = reportingService;
    }
    //write the logic to deposit
    public void deposit(Account account, double amount) {
        account.deposit(amount);
        loggingService.log("Deposit of " + amount + " to account " + account.getAccountNumber());
        reportingService.generateReport(account);
    }
}
