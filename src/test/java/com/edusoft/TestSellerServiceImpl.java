package com.edusoft;

import com.edusoft.dto.Seller;
import com.edusoft.service.impl.SellerServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TestSellerServiceImpl {
    //定义一个服务层对象
    SellerServiceImpl service;

    @Before
    public void init() {
        service = new SellerServiceImpl();
    }

    @Test
    public void testAdd() throws SQLException {
        Seller seller = new Seller();
        seller.setUsername("Here we go");
        System.out.println(service.add(seller));
    }

    @Test
    public void testUpdate() throws SQLException {
        //        查询要修改的对象
        String id = "20171018085551030";
        Seller seller = service.findOneById(id);
//        如果找到，可进行修改，否则提示没有找到
        if (seller != null) {
//            显示修改前的信息
            System.out.println("before update:" + seller);
//            进行修改，如果改成功，显示数据，否则显示修改失败
//            改写要修改的内容
            seller.setUrl("http://te.test.com");
//          ...
            if (service.update(seller)) {
                System.out.println(seller);
            } else {
                System.out.println("update failure");
            }
//            显示修改后的信息
        } else {
            System.out.println("no found!");
        }
    }
    @Test
    public void testFindOneById() throws SQLException {
        String id = "20171018085551030";
        System.out.println(service.findOneById(id));
    }

    /**
     * 测试登录
     */
    @Test
    public void testLogin() throws SQLException {
//        生成查询map
        Map map = new HashMap();
        map.put("username", "chen");
        map.put("password", "digen");
        System.out.println(service.login(map));
    }
}
