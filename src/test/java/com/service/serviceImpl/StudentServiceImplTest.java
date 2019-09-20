package com.service.serviceImpl;


import com.pojo.Student;
import com.service.StudentService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.Timestamp;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class StudentServiceImplTest {

    Logger logger = Logger.getLogger(StudentServiceImplTest.class);

    @Resource
    StudentService studentService;
    Student stu = new Student();

    /**
     *添加
     */
    @Test
    public void insert() {

        stu.setImg(".JPEG");
        stu.setPostion("CEO");
        stu.setName("三太子");
        stu.setDescription("as亮点封河南省地方【");
        stu.setSalary(12000);
        stu.setCreateAt(new Timestamp(System.currentTimeMillis()));
        stu.setUpdateAt(new Timestamp(System.currentTimeMillis()));
        for (int a = 0; a <= 10; a++) {
            studentService.insert(stu);
        }

    }

    /**
     *根据ID删除
     */
    @Test
    public void deleteByPrimaryKey() {
        studentService.deleteByPrimaryKey(11L);
    }


    /**
     *动态更新
     */
    @Test
    public void updateByPrimaryKeySelective() {
        stu.setUpdateAt(new Timestamp(System.currentTimeMillis()));
        stu.setSalary(15000);
        stu.setId(2l);
        studentService.updateByPrimaryKeySelective(stu);
    }


    /**
     * 查询前四
     */
    @Test
    public void fourth() {
        logger.info(studentService.fourth());
    }

    /**
     * 查询全表
     */
    @Test
    public void list() {
        logger.info(studentService.list());
    }
}