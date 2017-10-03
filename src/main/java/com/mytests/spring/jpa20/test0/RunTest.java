package com.mytests.spring.jpa20.test0;

import com.mytests.spring.jpa20.test0.configs.MyConfig1;
import com.mytests.spring.jpa20.test0.data.MyChinsEntity;
import com.mytests.spring.jpa20.test0.repositories.ChinsRepository;
import com.mytests.spring.jpa20.test0.services.ChinsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

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
        System.out.println("========= sorted ebony chinchillas:");
        List<MyChinsEntity> sortedBoys = service.findByColorAndSort("ebony", new Sort("name"));
        for (MyChinsEntity sb : sortedBoys) {
            System.out.println(sb.toString());
        }
        System.out.println("========= native query test:");
        Page<MyChinsEntity> nativeSortedBoys = service.nativeQueryTest1();
        for (MyChinsEntity sb : nativeSortedBoys) {
            System.out.println(sb.toString());
        }
        System.out.println("========= native query test2:");
        Page<MyChinsEntity> nativeSortedBoys2 = service.nativeQueryTest2();
        for (MyChinsEntity sb : nativeSortedBoys2) {
            System.out.println(sb.toString());
        }
        System.out.println("========= named native query test:");
        List<MyChinsEntity> nChins = service.testNativeNamedQuery(10);
        for (MyChinsEntity ccc : nChins ) {
            System.out.println(ccc.toString());
        }
        System.out.println("========= procedure test:");
        int test = service.testProcedure("name1", "surname1");
        System.out.println(test);

        System.out.println("========= findAllByOrderByName test:");
        List<MyChinsEntity> orderedChins = service.testAllOrdered();
        for (MyChinsEntity ccc : orderedChins ) {
            System.out.println(ccc.toString());
        }
        System.out.println("============exists tests:");
        System.out.println(service.checkExistsQueries());
    }

}