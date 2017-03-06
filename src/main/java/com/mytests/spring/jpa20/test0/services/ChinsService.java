package com.mytests.spring.jpa20.test0.services;

import com.mytests.spring.jpa20.test0.data.MyChinsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 12/19/2016.
 * Project: SpringJPA20_test0
 * *******************************
 */
public interface ChinsService {

    List<MyChinsEntity> listAll();
    List<MyChinsEntity> listBoys();
    List<MyChinsEntity> listGirls();
    List<MyChinsEntity> listBlackBoys();
    MyChinsEntity findChinById(int id);
    MyChinsEntity findChinByName(String name);
    List<MyChinsEntity> findSmallOnes(int weight);
    List<MyChinsEntity> findByWeightAndSex(int weight, String sex);
    List<MyChinsEntity> findByColorAndSort(String colorPattern, Sort sort);
    int testProcedure(String a1, String a2);
    Page<MyChinsEntity> nativeQueryTest1();

    Page<MyChinsEntity> nativeQueryTest2();

    List<MyChinsEntity> testNativeNamedQuery(int id);
}
