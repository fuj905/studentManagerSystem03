package com.pandawork.mapper;

import com.pandawork.common.entity.Student;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Created by fujia on 2016/3/28.
 *
 *
 */
public interface StudentMapper {

    /**
     * 查询所有学生列表
     * @return
     * @throws Exception
     */
    public List<Student> listAll( ) throws Exception;

    /**
     * 查询所有记录数目
     * @return
     * @throws Exception
     */
    public Integer countAll() throws Exception;

    /**
     * 根据id查询信息
     * @param id
     * @return
     * @throws Exception
     */
    public Student queryById(@Param("id") int id) throws Exception;

    /**
     * 增加学生信息
     * @param student
     * @throws Exception
     */
    public void newStudent(@Param("student") Student student) throws Exception;

    /**
     * 更新学生信息
     * @param student
     * @throws Exception
     */
    public void update(@Param("student") Student student) throws Exception;

    /**
     *删除学生信息
     * @param
     * @param id
     * @throws Exception
     */
    public boolean delById(@Param("id") int id) throws Exception;

    /**
     * 根据性别查询学生
     * @param student
     * @return
     * @throws Exception
     */
    public Student queryByName(@Param("student") String student) throws Exception;

    /**
     * 查询学生
     * @param student
     * @return
     * @throws Exception
     */
//    public Student queryStudent(@Param("student")Student student) throws Exception;

}
