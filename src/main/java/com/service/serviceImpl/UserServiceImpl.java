package com.service.serviceImpl;



import com.aliyun.OSSClientUtil;
import com.mapper.UserMapper;
import com.pojo.User;
import com.redis.JedisClient;
import com.service.UserService;
import com.utils.MemcachedUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author Administrator
 */
@Service
public class UserServiceImpl implements UserService {

    Logger logger=Logger.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Resource
    JedisClient jedisClient;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int register(User record) {
        return userMapper.register(record);
    }

    @Override
    public User selectByName(String name) {

        return userMapper.selectByName(name);
    }

    @Override
    public User selectByPhone(String phone) {
        return userMapper.selectByPhone(phone);
    }

    @Override
    public User selectByEmail(String email) {
        return userMapper.selectByEmail(email);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<User> list() {
        return userMapper.list();
    }

    @Override
    public User loginCheck(String name, String pwd) {
        return userMapper.loginCheck(name,pwd);
    }

    @Override
    public User loginCheck1(User user) {
        return userMapper.loginCheck1(user);
    }

    @Override
    public String updateHead(MultipartFile file) throws Exception {
        if (file == null || file.getSize() <= 0) {
            logger.info("file不能为空");
        }
        OSSClientUtil ossClient=new OSSClientUtil();
        String name = ossClient.uploadImg2Oss(file);
        String imgUrl = ossClient.getImgUrl(name);
        String[] split = imgUrl.split("\\?");
        return split[0];

    }

}
