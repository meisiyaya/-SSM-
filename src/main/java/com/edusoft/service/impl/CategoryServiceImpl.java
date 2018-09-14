package com.edusoft.service.impl;

import com.edusoft.dao.impl.CategoryDaoImpl;
import com.edusoft.dto.Category;
import com.edusoft.service.IBaseService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

//商品分类服务层接口实现
public class CategoryServiceImpl implements IBaseService<Category> {
    //服务层调用持久层的实现，因此，在服务层实现里，new一个持久层的对象
    CategoryDaoImpl cdi = new CategoryDaoImpl();

    @Override
    public boolean add(Category category) throws SQLException {
        //调用持久层的方法，以满足服务的需要
        //把服务层这里传入的对象category 参数传给持久层方法
        return cdi.add(category);
    }

    //每次添加服务层的实现了，服务层的接口就也得再添加函数接口
    @Override
    public List<Category> findByProp(Map map) throws SQLException {
        //服务层调用持久层，返回一个持久层方法的结果
        return cdi.findByProp(map);
        //每次新增加一个接口 一个持久层服务之后，就可以先进行测试了
        //这里同上，还是用服务层的测试，TestCategoryServiceImpl.java
    }

    @Override
    public boolean update(Category category) throws SQLException {
        return cdi.update(category);
    }

    @Override
    public Category findOneById(String id) throws SQLException {
        return cdi.findOneByID(id);
    }

//    @Override
    public Category findOneByProp(Map map) throws SQLException {
        return cdi.findOneByProp(map);
    }
}
