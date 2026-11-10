package com.solid.pattern.srp_sol;

public class ReportingServicePdfImpl implements  ReportingService {
    @Override
    public void generateReport(Account account) {
        System.out.println("PDF Report: " + account.getAccountNumber() + " " + account.getBalance());
    }
}
