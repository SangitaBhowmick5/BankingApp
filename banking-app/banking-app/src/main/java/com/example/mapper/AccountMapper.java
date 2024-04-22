package com.example.mapper;

import com.example.dto.AccountDTO;
import com.example.entity.Account;

public class AccountMapper {

    public static Account mapToAcc(AccountDTO accountDTO){
        Account account=new Account(
               accountDTO.getId(),
               accountDTO.getAccHolderName(),
               accountDTO.getBalance()
        );
        return account;
    }

    public static AccountDTO mapToAccDTO(Account account){
        AccountDTO accountDTO=new AccountDTO(
                account.getId(),
                account.getAccHolderName(),
                account.getBalance()
        );
        return accountDTO;
    }
}
