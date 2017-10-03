package com.mytests.spring.jpa20.test0.repositories;

import com.mytests.spring.jpa20.test0.data.MyChinsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
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

    List<MyChinsEntity> findAllByOrderByColorAscNameAsc();

    List<MyChinsEntity> findAll();

    List<MyChinsEntity> findBySex(String sex);

    MyChinsEntity findById(int id);

    Boolean existsByNameEndsWithAndColorContains(String name, String color);
    List<MyChinsEntity> existsByNameContaining(String name);

    @Query(value = "select u from MyChinsEntity u where u.color like %?1%")
    List<MyChinsEntity> sortedChinsByColorPattern(String colorPattern, Sort sort);


    String EXPR1 = "SELECT count(*) FROM chins WHERE sex = ?1";
    String EXPR0 = "SELECT * FROM chins WHERE sex = ?1 ORDER BY ?#{#pageable}";

    @Query(value = EXPR0, countQuery = EXPR1, nativeQuery = true)
    Page<MyChinsEntity> nativeQuerySorted(String sex, Pageable pageable);

    @Query(value =
            "\n #pageable \n SELECT id, name, color, birthday, weight, sex, forSale FROM chins WHERE sex = ?1 ",
            countQuery = "SELECT count(*) FROM chins WHERE sex = ?1",
            nativeQuery = true)
    Page<MyChinsEntity> nativeQuerySorted2(String sex, Pageable pageable);
}
