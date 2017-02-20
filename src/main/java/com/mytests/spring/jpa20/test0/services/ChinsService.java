package com.mytests.spring.jpa20.test0.services;

import com.mytests.spring.jpa20.test0.data.MyChinsEntity;

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
}
