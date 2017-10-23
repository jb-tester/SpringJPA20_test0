package com.mytests.spring.jpa20.test0.repositories;

import com.mytests.spring.jpa20.test0.data.MyChinsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 2/16/2017.
 * Project: SpringJPA20_test0
 * *******************************
 */
public interface ChinchillasRepository extends MyBaseIntermediateRepository<MyChinsEntity,Integer> {

    List<MyChinsEntity> weightAndSexOrderByForSale(int weight, String sex);

    List<MyChinsEntity> readFooSexBarBySex(String sex);

    /**
     * @param sex - male/female
     * @param color - color1
     * @param color2 - color2
     * @return list of chinchillas of specified sex and color
     */
    List<MyChinsEntity> getMyChinsEntitiesBySexEqualsAndColorContainsOrColorContains(String sex, String color, String color2);

    @Query(value = "select c from MyChinsEntity c where c.name = :chinName", name = "MyChinsEntity.firstQuery")
    MyChinsEntity firstQuery(@Param("chinName")String name);

    /**
    * for the named query MyChinsEntity.secondQuery
    */
    List<MyChinsEntity> secondQuery(int weight);

    /**
     * for the named query MyChinsEntity.firstNativeQuery
     */
    List<MyChinsEntity> firstNativeQuery(int id);

    @Procedure(procedureName = "countTab1")
    Integer countTab1Procedure();

    @Procedure(procedureName = "test3", outputParameterName = "arg3")
    Integer test3Procedure(@Param("arg1")String arg1,@Param("arg2") String arg2, @Param("arg3") Integer arg3);

    @Query(value = "INSERT into chins(id, name, color, birthday, weight, sex, forSale) VALUES (20, '', '', '', '', 0, '')",
            nativeQuery = true)
    default void method1() {
        System.out.println("===default method method1===");;
    }

}
