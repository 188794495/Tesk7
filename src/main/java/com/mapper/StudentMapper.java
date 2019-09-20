package com.mapper;

import com.pojo.Student;

import java.util.List;

/**
 * @author Administrator
 */
public interface StudentMapper {
    /**
     * 根据ID删除
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入
     *
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
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Student record);

    /**
     * 根据ID更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(Student record);

    /**
     * 查询全表的前四个
     */

    List<Student> fourth();

    /**
     * 查询全表
     *
     * @return
     */
    List<Student> list();
}