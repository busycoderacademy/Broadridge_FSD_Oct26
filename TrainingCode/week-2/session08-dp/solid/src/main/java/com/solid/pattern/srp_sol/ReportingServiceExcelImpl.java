package com.solid.pattern.srp_sol;

public class ReportingServiceExcelImpl implements  ReportingService {
    @Override
    public void generateReport(Account account) {
        System.out.println("Excel Report: " + account.getAccountNumber() + " " + account.getBalance());
    }
}
