package com.example.controller;

import com.example.dto.AccountDTO;
import com.example.entity.Account;
import com.example.mapper.AccountMapper;
import com.example.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;
    //dependency injection by constructor
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //create the new account
    @PostMapping
    public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO accountDTO){
        return new ResponseEntity<>(accountService.createAccount(accountDTO), HttpStatus.CREATED);
    }

    //finding single acc by id
    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id){
        AccountDTO accDTO= accountService.getAccountById(id);
      //  return new ResponseEntity<>(accDTO, HttpStatus.OK);
        return ResponseEntity.ok(accDTO);
    }

    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAllAccounts(){
        List<AccountDTO> accounts=accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDTO> deposit(@PathVariable Long id,@RequestBody Map<String,Double> request){

        Double amount = request.get("amount");
        AccountDTO accountDTO= accountService.deposit(id, amount);
        return ResponseEntity.ok(accountDTO);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDTO> withdraw(@PathVariable Long id,@RequestBody Map<String, Double> request){
        Double amount= request.get("amount");
        AccountDTO accountDTO=accountService.withdraw(id,amount);
        return ResponseEntity.ok(accountDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
}
