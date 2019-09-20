package com.service;

import com.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface UserService {
    /**
     * 根据ID删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入
     * @param record
     * @return
     */
    int insert(User record);

    /**
     * 注册
     * @param record
     * @return
     */
    int register(User record);

    /**
     * 根据name查询
     * @param name
     * @return
     */
    User selectByName(String name);

    User selectByPhone(String phone);

    User selectByEmail(String email);
    /**
     * 动态更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * 更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(User record);

    /**
     * 查询全表
     * @return
     */
    List<User> list();

    /**
     * 登录验证
     * @param name
     * @param pwd
     */
    User loginCheck(@Param("name")String name, @Param("pwd")String pwd);


    User loginCheck1(User user);


    String updateHead(MultipartFile file)throws Exception;


}
