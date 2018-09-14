package com.edusoft.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

//服务层通用接口
public interface IBaseService<T> {
    boolean add(T t) throws SQLException;

    //商品分类持久层实现之后，就可以在上层服务层添加查询的服务了
    List<T> findByProp(Map map) throws SQLException;

    boolean update(T t) throws SQLException;

    T findOneById(String id) throws SQLException;

//    T findOneByProp(Map map) throws SQLException;
}
