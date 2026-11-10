package com.solid.pattern.srp_sol;

public class Tester {
    public static void main(String[] args) {
        Account account = new Account("121",5000.00);

        //dependency injection : manual DP vs automatic DP: Spring
        LoggingService loggingService = new LoggingServiceDbImpl();
        ReportingService reportingService = new ReportingServicePdfImpl();
        AccountService accountService =
                new AccountService(loggingService, reportingService);

        accountService.deposit(account, 1000);
    }
}
