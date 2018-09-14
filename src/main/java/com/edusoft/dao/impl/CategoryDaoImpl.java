package com.edusoft.dao.impl;

import com.edusoft.dao.Db;
import com.edusoft.dao.IBaseDao;
import com.edusoft.dto.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//最终这个持久层类接口实现之后，需要传递给服务层。因为服务层调用持久层


//对商品分类对象 持久层 具体实现 category dao Impl
//下一行“<>”括号里 输入Cate的时候出现了一个自带的Category(java.util.Locale) 这个不是我们即将创建的
public class CategoryDaoImpl  implements IBaseDao<Category> {
    //连接
    Connection conn = Db.getConn();

    PreparedStatement ps;
    //后执行以下的函数
    ResultSet rs;

    //实现接口需要实现接口里的所有方法
    @Override
    public boolean add(Category category) throws SQLException {
        //这里还涉及到什么数据库开流闭流之类的，而且下一行的sql语句可能以后还要写成类吧。
        // 问号？是因为那两个填充值需要用户输入
        String sql = "insert into category(text, parent) values(?,?)";
        //ps 预先处理这一句sql语句，然后把参数传给其他
        ps = conn.prepareStatement(sql); //返回一个prepareStatement的对象
        ps.setString(1,category.getText());
        ps.setString(2,category.getParent());
        int i = ps.executeUpdate();
        return i>0? true:false; //逻辑判断可能需要写在服务层，这里是持久层数据库的操作
    }

    @Override
    public boolean update(Category category) throws SQLException {
        String sql = "update category set text = ?, parent = ? where id = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1,category.getText());
        ps.setString(2,category.getParent());
        ps.setString(3,category.getId());
        return ps.executeUpdate()>0? true:false;
    }

    @Override
    public Category findOneByID(String id) throws SQLException {
            Category category = null;
            String sql = "select * from category where id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
//            如果返回记录集不为空，则生成并填充对象
                category = new Category();
                category.setId(rs.getString("id"));
                category.setText(rs.getString("text"));
                category.setParent(rs.getString("parent"));
            }
            return category;
    }


    @Override
    public List<Category> findByProp(Map map) throws SQLException {
        //安排一个列表集合进去
        List<Category> list = new ArrayList<Category>();
        String sql = "SELECT * FROM category where text LIKE '%"+map.get("text")+"%'";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        //执行查询语句，返回的是一个记录集
        while (rs.next()){
            Category category = new Category();
            category.setId(rs.getString("id"));
            category.setText((rs.getString("text")));
            category.setParent((rs.getString("parent")));
            //循环结束之后，把结果依次填入列表
            list.add(category);
        }
        return list;
    }

    @Override
    public Category findOneByProp(Map map) throws SQLException {
        //视频到这里，先更改一下包目录结构，dao, dto
        //这里是接口的具体实现，目录应该在持久层之下dao.impl
        Category category = null;
        String sql = "select id, text, parent from category where id = ?";//+ map.get("id");
        System.out.println(sql);
        ps = conn.prepareStatement(sql);
//        ps.setString(1,category.getID());
        ps.setString(1, (String) map.get("id"));//(String) category.getId()
//        System.out.println(category.getId());
        rs = ps.executeQuery();
        while(rs.next()){
            category = new Category();
            category.setId(rs.getString("id"));
            category.setText(rs.getString("text"));
            category.setParent(rs.getString("parent"));
        }
        return category;
    }
}
