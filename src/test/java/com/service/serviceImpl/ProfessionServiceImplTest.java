package com.service.serviceImpl;


import com.pojo.Profess;
import com.service.ProfessionService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})


public class ProfessionServiceImplTest {
    Logger logger = Logger.getLogger(ProfessionServiceImplTest.class);

    @Resource
    private ProfessionService professionService;
    Profess ps = new Profess();

    /**
     * 插入
     */
//    @Test
//    public void insert() {
//        ps.setImg(".jpeg");
//        ps.setDirection("后端攻城狮");
//        ps.setProfession("java攻城狮");
//        ps.setDescription("大嫂告诉二嫂，java真好");
//        ps.setThreshold(2);
//        ps.setDifficulty(2);
//        ps.setPeriod("2-5");
//        ps.setCompany(100000);
//        ps.setSalaryOne(5000);
//        ps.setSalaryTwo(10000);
//        ps.setSalaryThree(50000);
//
//        for (int a = 0; a < 10; a++) {
//            professionService.insert(ps);
//        }
//    }

    /**
     * 根据ID删除
     */
    @Test
    public void deleteByPrimaryKey() {
        professionService.deleteByPrimaryKey(51L);
    }


    /**
     * 动态更细
     */
    @Test
    public void updateByPrimaryKeySelective() {
        ps.setProfession("IOS攻城狮");
        ps.setId(2L);
        professionService.updateByPrimaryKeySelective(ps);
    }


    /**
     * 查询全表
     */
    @Test
    public void list() {
        logger.info(professionService.list());
    }
}