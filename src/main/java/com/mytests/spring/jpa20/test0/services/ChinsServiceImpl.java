package com.mytests.spring.jpa20.test0.services;

import com.mytests.spring.jpa20.test0.data.MyChinsEntity;
import com.mytests.spring.jpa20.test0.repositories.ChinsRepository;
import com.mytests.spring.jpa20.test0.repositories.ChinchillasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 12/19/2016.
 * Project: SpringJPA20_test0
 * *******************************
 */
@Service
public class ChinsServiceImpl implements ChinsService {


    /**
     * repository annotated with @RepositoryDefinition
     */
    private final ChinsRepository chinsRepository;
    /**
     * repository extends CrudRepository
     */
    private final ChinchillasRepository chinchillasRepository;

    @Autowired
    public ChinsServiceImpl(ChinsRepository chinsRepository, ChinchillasRepository chinchillasRepository) {
        this.chinsRepository = chinsRepository;
        this.chinchillasRepository = chinchillasRepository;
    }


    @Override
    public List<MyChinsEntity> listAll() {
        return chinsRepository.findAll();
    }

    @Override
    public List<MyChinsEntity> listBoys() {
        return chinsRepository.findBySex("male");
    }

    @Override
    public List<MyChinsEntity> listGirls() {
        return chinsRepository.findBySex("female");
    }

    @Override
    public List<MyChinsEntity> listBlackBoys() {
        return chinchillasRepository.getMyChinsEntitiesBySexEqualsAndColorContainsOrColorContains("male","black","dark");
    }

    @Override
    public MyChinsEntity findChinById(int id) {

        return chinsRepository.findById(id);
    }

    @Override
    public MyChinsEntity findChinByName(String name) {

        return chinchillasRepository.firstQuery(name);
    }

    @Override
    public List<MyChinsEntity> findSmallOnes(int weight) {
        return chinchillasRepository.secondQuery(weight);
    }

    @Override
    public List<MyChinsEntity> findByWeightAndSex(int weight, String sex) {
        return chinchillasRepository.weightAndSexOrderByForSale(weight,sex);
    }

    @Override
    public List<MyChinsEntity> findByColorAndSort(String colorPattern, Sort sort) {
        return chinsRepository.sortedChinsByColorPattern(colorPattern, sort);
    }

    @Override
    public int testProcedure(String a1, String a2) {
        return chinchillasRepository.test3Procedure(a1,a2, chinchillasRepository.countTab1Procedure()+1);
    }

    @Override
    public Page<MyChinsEntity> nativeQueryTest1() {
        return chinsRepository.nativeQuerySorted("male", new PageRequest(1,3));
    }
    @Override
    public Page<MyChinsEntity> nativeQueryTest2() {
        return chinsRepository.nativeQuerySorted2("male", new PageRequest(0,3));
    }

    @Override
    public List<MyChinsEntity> testNativeNamedQuery(int id){
        return chinchillasRepository.firstNativeQuery(id);
    }

    @Override
    public List<MyChinsEntity> testAllOrdered() {
        return chinsRepository.findAllByOrderByColorAscNameAsc();
    }

}
