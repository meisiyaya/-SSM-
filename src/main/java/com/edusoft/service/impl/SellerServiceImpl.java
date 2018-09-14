package com.edusoft.service.impl;

import com.edusoft.dao.IBaseDao;
import com.edusoft.dao.impl.SellerDaoImpl;
import com.edusoft.dto.Seller;
import com.edusoft.service.IBaseService;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class SellerServiceImpl implements IBaseService<Seller> {
    //持久层对象
    SellerDaoImpl dao = new SellerDaoImpl();

    @Override
    /**
     * 添加
     */
    public boolean add(Seller seller) throws SQLException {
        return dao.add(seller);
    }

    @Override
    /**
     * 模糊查询
     */
    public List<Seller> findByProp(Map map) throws SQLException {
        return dao.findByProp(map);
    }

    @Override
    /**
     * 更新数据
     */
    public boolean update(Seller seller) throws SQLException {
        return dao.update(seller);
    }

    @Override
    /**
     * 精确查询
     */
    public Seller findOneById(String id) throws SQLException {
        return dao.findOneByID(id);
    }


//    @Override
//    public Seller findOneByProp(Map map) throws SQLException {
//        return (Seller) dao.findByProp(map);
//    }

    //==========================服务层放一些网页传入的数据进行处理过滤方面的==================
    //==========================比如先在服务层验证 登陆密码账户等等===========================
    /**
     * 判断商家名称是否存在
     *
     * @param map
     * @return
     * @throws SQLException
     */
    public boolean isExist(Map map) throws SQLException {
        return dao.findOneByProp(map) != null ? true : false;
    }

    /**
     * 商家登录
     *
     * @param map
     * @return
     * @throws SQLException
     */
    public Seller login(Map map) throws SQLException {
        return dao.findOneByProp(map);
    }
}
