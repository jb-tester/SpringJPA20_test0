package com.mytests.spring.jpa20.test0;

import com.mytests.spring.jpa20.test0.configs.MyConfig1;
import com.mytests.spring.jpa20.test0.data.MyChinsEntity;
import com.mytests.spring.jpa20.test0.repositories.ChinsRepository;
import com.mytests.spring.jpa20.test0.services.ChinsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Iterator;
import java.util.List;

/**
 * *******************************
 * Created by Irina.Petrovskaya on 12/19/2016.
 * Project: SpringJPA20_test0
 * *******************************
 */
public class RunTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MyConfig1.class);
        ChinsService service = (ChinsService) ctx.getBean("chinsServiceImpl");
        ChinsRepository repo = (ChinsRepository) ctx.getBean("chinsRepository");
        System.out.println("========= the 3-d one's name:");
        System.out.println(service.findChinById(3).getName());
        System.out.println("=========  all:");
        List<MyChinsEntity> allChins = service.listAll();
        for (MyChinsEntity c : allChins) {
            System.out.println(c.toString());
        }

        System.out.println("========= girls:");
        List<MyChinsEntity> girls = service.listGirls();
        for (MyChinsEntity girl : girls) {
            System.out.println(girl.toString());
        }
        System.out.println("========= black boys:");
        List<MyChinsEntity> bbs = service.listBlackBoys();
        for (MyChinsEntity bb : bbs) {
            System.out.println(bb.toString());
        }
        System.out.println("========= Bublik:");
        MyChinsEntity bublik = service.findChinByName("Bublik");
        System.out.println(bublik.toString());
        System.out.println("========= small chinchillas:");
        List<MyChinsEntity> smalls = service.findSmallOnes(500);
        for (MyChinsEntity small : smalls) {
            System.out.println(small.toString());
        }
        System.out.println("========= girls of 600:");
        List<MyChinsEntity> fatGirls = service.findByWeightAndSex(600,"female");
        for (MyChinsEntity sg : fatGirls) {
            System.out.println(sg.toString());
        }
    }

}