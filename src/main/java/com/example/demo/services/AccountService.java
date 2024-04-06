package com.example.demo.services;


import com.example.demo.entities.AccountEntity;
import com.example.demo.model.AccountRequest;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.AccountRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {


    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public Integer createAccount(AccountRequest accountRequest)
    {
        AccountEntity entity = new AccountEntity();
        entity.setType(accountRequest.getType());
        entity.setName(accountRequest.getName());
        entity = accountRepository.save(entity);

        return entity.getId();

    }

    public String updateAccount(AccountRequest accountRequest)
    {

        Optional<AccountEntity> accountEntityOpt = accountRepository.findById(accountRequest.getId());

        if(accountEntityOpt.isPresent())
        {
            AccountEntity accountEntity = accountEntityOpt.get();
            accountEntity.setName(accountRequest.getName());
            accountEntity.setType(accountRequest.getType());
            accountRepository.save(accountEntity);
        }else{
            throw new RuntimeException("Account not exist");
        }
        return "success";

    }

    public void deleteAccount(Integer id)
    {
        accountRepository.deleteById(id);
    }

    public AccountEntity getAccount(Integer id)
    {
        Optional<AccountEntity> entityOpt = accountRepository.findById(id);

        if(entityOpt.isPresent())
        {
            return entityOpt.get();
        }else{
            throw new RuntimeException("Account not exist");
        }

    }

    public List<AccountEntity> getAccounts() {
        return (List<AccountEntity>) accountRepository.findAll();
    }
}
