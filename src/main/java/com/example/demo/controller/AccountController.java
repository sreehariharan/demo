package com.example.demo.controller;


import com.example.demo.entities.AccountEntity;
import com.example.demo.model.AccountRequest;
import org.springframework.web.bind.annotation.*;
import com.example.demo.services.AccountService;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public AccountEntity getAccount(@PathVariable("id") Integer id)
    {
        return accountService.getAccount(id);
    }

    @GetMapping()
    public List<AccountEntity> getAccounts()
    {
        return accountService.getAccounts();
    }

    @PostMapping
    public Integer createAccount(@RequestBody AccountRequest accountRequest){

        System.out.println("Hello");

        return accountService.createAccount(accountRequest);

    }

    @PutMapping
    public String updateAccount(@RequestBody AccountRequest accountRequest){
        return accountService.updateAccount(accountRequest);

    }



}
