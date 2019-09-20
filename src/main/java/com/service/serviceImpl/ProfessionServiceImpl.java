package com.service.serviceImpl;

import com.mapper.ProfessMapper;
import com.pojo.Profess;
import com.redis.JedisClient;
import com.service.ProfessionService;
import com.utils.MemcachedUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@Service("ProfessionService")
public class ProfessionServiceImpl implements ProfessionService {

//    Logger logger=Logger.getLogger(ProfessionServiceImpl.class);

    java.util.logging.Logger logger = java.util.logging.Logger.getLogger(String.valueOf(ProfessionServiceImpl.class));
    @Autowired
    ProfessMapper professMapper;

    @Resource
    JedisClient jedisClient;
    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        return professMapper.deleteByPrimaryKey(id);
    }


    /**
     * 插入
     *
     * @param record
     * @return
     */
    @Override
    public int insert(Profess record) {
        return professMapper.insert(record);
    }

    /**
     * 动态插入
     *
     * @param record
     * @return
     */
    @Override
    public int insertSelective(Profess record) {
        return professMapper.insertSelective(record);
    }

    /**
     * 动态更新
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(Profess record) {
        return professMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 根据ID更新
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKey(Profess record) {
        return professMapper.updateByPrimaryKey(record);
    }


    /**
     * 查询全表
     *
     * @return
     */
    @Override
    public List<Profess> list() {
        List<Profess> profess= (List<Profess>) jedisClient.getList("professes");
        logger.info("从缓存中读取"+profess);
        if(profess==null){
            logger.info("缓存profess为空，从数据库中获取");
            profess=professMapper.list();
                jedisClient.setList("professes",profess);
                logger.info("储存的对象为："+profess);
        }
//        jedisClient.del("professes");
        return profess;
    }
}
