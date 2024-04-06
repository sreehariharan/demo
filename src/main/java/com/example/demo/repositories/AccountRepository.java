package com.example.demo.repositories;


import com.example.demo.entities.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AccountRepository extends CrudRepository<AccountEntity, Integer> {

    List<AccountEntity> findAllByName(String name);
    List<AccountEntity> findAllByNameAndType(String name, String type);

}
