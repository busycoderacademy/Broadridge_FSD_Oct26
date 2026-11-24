package com.bankapp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AccountDto {
    private int id;
    private String name;
    private double balance;
}
