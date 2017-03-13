package com.mytests.spring.jpa20.test0.repositories;

import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 3/10/2017.
 * Project: SpringJPA20_test0
 * *******************************
 */
@NoRepositoryBean
public interface MyBaseIntermediateRepository <T, ID extends Serializable> extends MyBaseRepository<T, ID> {
    List<T> findAll();
}
