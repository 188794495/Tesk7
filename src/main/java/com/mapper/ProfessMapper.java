package com.mapper;

import com.pojo.Profess;

import java.util.List;

/**
 * @author Administrator
 */
public interface ProfessMapper {

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
    int insert(Profess record);

    /**
     * 动态插入
     *
     * @param record
     * @return
     */
    int insertSelective(Profess record);

    /**
     * 动态更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Profess record);

    /**
     * 根据ID更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(Profess record);


    /**
     * 查询全表
     *
     * @return
     */
    List<Profess> list();
}