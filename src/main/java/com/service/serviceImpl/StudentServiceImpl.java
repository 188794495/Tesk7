package com.service.serviceImpl;

import com.mapper.StudentMapper;
import com.pojo.Student;
import com.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    StudentMapper studentMapper;

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Long id) {
        return studentMapper.deleteByPrimaryKey(id);
    }


    /**
     * 插入
     *
     * @param record
     * @return
     */
    @Override
    public int insert(Student record) {
        return studentMapper.insert(record);
    }

    /**
     * 动态插入
     *
     * @param record
     * @return
     */
    @Override
    public int insertSelective(Student record) {
        return studentMapper.insertSelective(record);
    }

    /**
     * 动态更新
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(Student record) {
        return studentMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 根据ID更新
     *
     * @param record
     * @return
     */
    @Override
    public int updateByPrimaryKey(Student record) {
        return studentMapper.updateByPrimaryKey(record);
    }


    /**
     * 查询全表
     *
     * @return
     */
    @Override
    public List<Student> list() {
        return studentMapper.list();
    }



    /**
     * 根据salary查询前四
     *
     * @return
     */
    @Override
    public List<Student> fourth() {
        return studentMapper.fourth();
    }
}

