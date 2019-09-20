package com.service;

import com.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public interface StudentService {

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);
    /**
     * 插入
     * @param record
     * @return
     */
    int insert(Student record);

    /**
     * 动态插入
     *
     * @param record
     * @return
     */
    int insertSelective(Student record);


    /**
     * 动态更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Student record);

    /**
     * 根据ID更新
     * @param record
     * @return
     */
    int updateByPrimaryKey(Student record);

    /**
     * 查询全表
     * @return
     */
    List<Student> list();



    /**
     * 查询全表的前四个
     */
    List<Student> fourth();
}
