package com.example.services.Impl;

import com.example.dto.AccountDTO;
import com.example.entity.Account;
import com.example.mapper.AccountMapper;
import com.example.repo.AccountRepository;
import com.example.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    AccountRepository accRepo;

    //dependency injection by constructor
    public AccountServiceImpl(AccountRepository accRepo) {
        this.accRepo = accRepo;
    }

    //creating the new account for banking
    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {
        Account account= AccountMapper.mapToAcc(accountDTO);
        Account savedAcc=accRepo.save(account);
        return AccountMapper.mapToAccDTO(savedAcc);
    }

      @Override
    public List<AccountDTO> getAllAccounts() {
        List<Account> accounts= accRepo.findAll();
        return accounts.stream().map(account -> AccountMapper.mapToAccDTO(account))
                .collect(Collectors.toList());
    }

    @Override
    public AccountDTO getAccountById(Long id) {

        Account account= accRepo
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Acc doesn't exist"));
        return AccountMapper.mapToAccDTO(account);
    }

    @Override
    public AccountDTO deposit(Long id, double amount) {

        Account account= accRepo
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Acc doesn't exist"));

        double total= account.getBalance() + amount;
        account.setBalance(total);
        Account savedAcc= accRepo.save(account);
        return AccountMapper.mapToAccDTO(savedAcc);
    }

    @Override
    public AccountDTO withdraw(Long id, double amount) {

        Account account= accRepo
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Acc doesn't exist"));

        if(account.getBalance() < amount){
            throw new RuntimeException("Insufficient balance");
        }

        double total= account.getBalance() - amount;
        account.setBalance(total);
        Account savedAcc=accRepo.save(account);
        return AccountMapper.mapToAccDTO(savedAcc);
    }

    @Override
    public void deleteAccount(Long id) {
        Account acc=accRepo.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        accRepo.deleteById(id);
    }
}
