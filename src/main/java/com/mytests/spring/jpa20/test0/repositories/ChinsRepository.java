package com.mytests.spring.jpa20.test0.repositories;

import com.mytests.spring.jpa20.test0.data.MyChinsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 12/19/2016.
 * Project: SpringJPA20_test0
 * *******************************
 */
@RepositoryDefinition(domainClass = MyChinsEntity.class, idClass = Integer.class)
public interface ChinsRepository
{
    List<MyChinsEntity> findAll();
    List<MyChinsEntity> findBySex(String sex);
    MyChinsEntity findById(int id);

}
