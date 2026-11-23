package com.bankapp.repo;

import com.bankapp.dto.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {
}
