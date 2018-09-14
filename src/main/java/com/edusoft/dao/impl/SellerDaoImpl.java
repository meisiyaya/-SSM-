package com.edusoft.dao.impl;

import com.edusoft.dao.Db;
import com.edusoft.dao.IBaseDao;
import com.edusoft.dto.Seller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class SellerDaoImpl implements IBaseDao<Seller> {
    Connection conn = Db.getConn();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public boolean add(Seller seller) throws SQLException {
        String sql = "insert into seller(realname,username," +
                "password,address,postcode,email,url,phone,logo) " +
                " values(?,?,?,?,?,?,?,?,?)";
        ps = conn.prepareStatement(sql);
        //植入参数
        ps.setString(1,seller.getRealname());
        ps.setString(2,seller.getUsername());
        ps.setString(3,seller.getPassword());
        ps.setString(4,seller.getAddress());
        ps.setString(5,seller.getPostcode());
        ps.setString(6,seller.getEmail());
        ps.setString(7,seller.getUrl());
        ps.setString(8,seller.getPhone());
        ps.setString(9,seller.getLogo());
        //        执行更新操作，并返回受影响的记录数
        int i = ps.executeUpdate();
//        将返回的整型值处理成要返回的逻辑值
        return i > 0 ? true : false;

    }

    @Override
    public boolean update(Seller seller) throws SQLException {
        //        定义要执行的sql语句
        String sql = "UPDATE seller SET realname=?," +
                "password=?,address=?,postcode=?,email=?,url=?," +
                "phone=?,logo=?,state=?,grade=?" + " WHERE  id=?";
        ps = conn.prepareStatement(sql);
        //植入参数
        ps.setString(1, seller.getRealname());
//        ps.setString(2, seller.getUsername());不提供修改
        ps.setString(2, seller.getPassword());
        ps.setString(3, seller.getAddress());
        ps.setString(4, seller.getPostcode());
        ps.setString(5, seller.getEmail());
        ps.setString(6, seller.getUrl());
        ps.setString(7, seller.getPhone());
        ps.setString(8, seller.getLogo());
        ps.setString(9, seller.getState());
        ps.setString(10, seller.getGrade());
        ps.setString(11, seller.getId());
        //        执行更新操作
        return ps.executeUpdate() > 0 ? true : false;
    }

    @Override
    public Seller findOneByID(String id) throws SQLException {
        Seller seller = null;
        String sql = "select id,realname,username,password,address," +
                "postcode,email,url,phone,logo,regdate,state,grade" +
                " from Seller where id=?";
        ps = conn.prepareStatement(sql);
//        植入参数
        ps.setString(1, id);
//        执行查询动作，返回记录集
        rs = ps.executeQuery();
//        处理返回的记录集
        if (rs.next()) {
//            生成对象
            seller = new Seller();
//            填充对象
            seller.setId(rs.getString("id"));
            seller.setAddress(rs.getString("address"));
            seller.setEmail(rs.getString("email"));
            seller.setGrade(rs.getString("grade"));
            seller.setLogo(rs.getString("logo"));
            seller.setPassword(rs.getString("password"));
            seller.setPhone(rs.getString("phone"));
            seller.setPostcode(rs.getString("postcode"));
            seller.setRealname(rs.getString("realname"));
            seller.setRegdate(rs.getDate("regdate"));
            seller.setState(rs.getString("state"));
            seller.setUsername(rs.getString("username"));
            seller.setUrl(rs.getString("url"));
        }
        return seller;
    }

    @Override
    public List<Seller> findByProp(Map map) throws SQLException {
        //        定义一个数组列表
        List<Seller> list = new ArrayList<Seller>();
//        如果不能识别占位符?，则拼接字符串
        String sql = "select id,realname,username,password,address," +
                "postcode,email,url,phone,logo,regdate,state,grade" +
                "from Seller ";
        if (map.containsKey("id")) {
            sql += " where id like '%" + map.get("id") + "%'";
        }
        if (map.containsKey("username")) {
            sql += " where username like '%" + map.get("username") + "%'";
        }
        if (map.containsKey("realname")) {
            sql += " where realname like '%" + map.get("realname") + "%'";
        }
        ps = conn.prepareStatement(sql);
//        执行查询动作，返回记录集
        rs = ps.executeQuery();
//        处理返回的记录集
        while (rs.next()) {
//            生成对象
            Seller Seller = new Seller();
//            填充对象
            Seller.setId(rs.getString("id"));
            Seller.setAddress(rs.getString("address"));
            Seller.setEmail(rs.getString("email"));
            Seller.setGrade(rs.getString("grade"));
            Seller.setLogo(rs.getString("logo"));
            Seller.setPassword(rs.getString("password"));
            Seller.setPhone(rs.getString("phone"));
            Seller.setPostcode(rs.getString("postcode"));
            Seller.setRealname(rs.getString("realname"));
            Seller.setRegdate(rs.getDate("regdate"));
            Seller.setState(rs.getString("state"));
            Seller.setUsername(rs.getString("username"));
            Seller.setUrl(rs.getString("url"));

//            向列表添加对象
            list.add(Seller);
        }
        return list;
    }

    @Override
    public Seller findOneByProp(Map map) throws SQLException {
        Seller seller = null;
        String sql = "select id,realname,username,password,address," +
                "postcode,email,url,phone,logo,regdate,state,grade" +
                " from seller ";
        if (map.containsKey("username")) {
            sql += " where username='" + map.get("username") + "'";//'chen'
        }
        if (map.containsKey("password")) {
            sql += " and password='" + map.get("password") + "'";
        }
        System.out.println(sql);
        ps = conn.prepareStatement(sql);
//        执行查询动作，返回记录集
        rs = ps.executeQuery();
//        处理返回的记录集
        if (rs.next()) {
//            生成对象
            seller = new Seller();
//            填充对象
            seller.setId(rs.getString("id"));
            seller.setAddress(rs.getString("address"));
            seller.setEmail(rs.getString("email"));
            seller.setGrade(rs.getString("grade"));
            seller.setLogo(rs.getString("logo"));
            seller.setPassword(rs.getString("password"));
            seller.setPhone(rs.getString("phone"));
            seller.setPostcode(rs.getString("postcode"));
            seller.setRealname(rs.getString("realname"));
            seller.setRegdate(rs.getDate("regdate"));
            seller.setState(rs.getString("state"));
            seller.setUsername(rs.getString("username"));
            seller.setUrl(rs.getString("url"));
        }
        return seller;
    }

}

