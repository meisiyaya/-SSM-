package com.edusoft.dao;

//这里定义一个通用的持久层接口，用于控制数据库
//IBaseDao: I: interface接口，base: 通用，Dao持久层

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

//泛型
public interface IBaseDao<T> {
    //一般来说，增删查改就定义在这里
    //面向接口编程
    /**
    add添加
     */
    boolean add(T t) throws SQLException;

    /**
     * 修改
     * @param t
     * @return
     */
    boolean update(T t) throws SQLException;


    //通过ID精确查
    //这里目前是String型
    T findOneByID(String id) throws SQLException;

    //集合查询参数
    /**
     * 根据条件模糊查询
     * @param map
     * @return
     */
    List<T> findByProp(Map map) throws SQLException;

    /**
     * 根据参数精确查询
     * @param map
     * @return
     */
    T findOneByProp(Map map) throws SQLException;


}
