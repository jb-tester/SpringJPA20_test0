package com.mytests.spring.jpa20.test0.repositories;

import com.mytests.spring.jpa20.test0.data.MyChinsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 2/16/2017.
 * Project: SpringJPA20_test0
 * *******************************
 */
public interface ChinchillasRepository extends CrudRepository<MyChinsEntity,Integer> {
    List<MyChinsEntity> weightAndSexOrderByForSale(int weight, String sex);
    List<MyChinsEntity> readFooSexBarBySex(String sex);

    /**
     * @param sex - male/female
     * @param color - color1
     * @param color2 - color2
     * @return list of chinchillas of specified sex and color
     */
    List<MyChinsEntity> getMyChinsEntitiesBySexEqualsAndColorContainsOrColorContains(String sex, String color, String color2);

    @Query(value = "select c from MyChinsEntity c where c.name = :name", name = "first")
    MyChinsEntity firstQuery(@Param("name")String name);
    /**
    * for the named query MyChinsEntity.secondQuery
    */
    List<MyChinsEntity> secondQuery(int weight);


}
