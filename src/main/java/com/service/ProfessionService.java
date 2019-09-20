package com.service;

import com.pojo.Profess;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public interface ProfessionService {


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
    int insert(Profess record);

    /**
     * 动态插入
     * @param record
     * @return
     */
    int insertSelective(Profess record);

    /**
     * 动态更新
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Profess record);

    /**
     * 根据ID更新
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

