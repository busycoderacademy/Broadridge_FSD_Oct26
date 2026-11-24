package com.bankapp.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    private int id;
    private String name;
    private double balance;
}
