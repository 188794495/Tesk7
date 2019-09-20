package com.service.serviceImpl;

import com.pojo.User;
import com.service.UserService;
import com.utils.DesUtils;
import com.utils.MD5Utils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserServiceImplTest {
    Logger logger = Logger.getLogger(UserServiceImplTest.class);
    @Resource
    private UserService userService;
    User user = new User();

    @Test
    public void deleteByPrimaryKey() {
        userService.deleteByPrimaryKey(1);

    }

    @Test
    public void insert() {
        user.setName("admin");
        user.setPwd("123456");
        user.setEmail("110@163.com");
        user.setQq(119);
        user.setPhone("123456");
        userService.insert(user);
    }

    //des加密
//    @Test
//    public void insertSelective() {
//        try {
//            DesUtils des=new DesUtils();
//            user.setPwd(des.encrypt("cc121213"));
//            user.setName("曹非凡");
//            user.setQq(188794495);
//            user.setEmail("yaho@163.com");
//            user.setPhone(1008611);
//            userService.insertSelective(user);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//MD5加密
    @Test
    public void register() {
        MD5Utils getMD5 = new MD5Utils();
        user.setPwd(getMD5.getMD5Code("123"));
        user.setName("曹非凡");
//        user.setQq(188794495);
//        user.setEmail("yaho@163.com");
        user.setPhone("13273804671");
//        user.setPicture("555");
        userService.register(user);
    }

    @Test
    public void selectByName() {
        logger.info(userService.selectByName("曹非凡"));
    }


    @Test
    public void updateByPrimaryKeySelective() {

        user.setPwd("968745");
        user.setName("曹非凡");
        user.setId(1);
        userService.updateByPrimaryKeySelective(user);
    }

    @Test
    public void updateByPrimaryKey() {

    }

    @Test
    public void list() {
        userService.list();
    }


    @Test
    public void loginCheck() {

        logger.info(userService.loginCheck("曹非凡","123"));
    }

    @Test
    public void selectByPhone() {
        logger.info(userService.selectByPhone("13273804671"));
    }

    @Test
    public void loginCheck1() {
        MD5Utils getMD5 = new MD5Utils();
        user.setPhone("13273804671");
        user.setPwd(getMD5.getMD5Code("123456"));
        logger.info(userService.loginCheck1(user));
    }
}
