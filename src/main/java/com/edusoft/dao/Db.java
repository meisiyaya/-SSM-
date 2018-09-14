package com.edusoft.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
//数据连接
public class Db {
    private static Connection conn; //全局变量conn创建

    private Db() { }

    static {

        try {
            //这里仅仅是读取所要的参数信息
            Properties pro=new Properties(); //属性
            pro.load(Db.class.getClassLoader().getResourceAsStream("config/db.properties"));//读取配置文件
            String driver=pro.getProperty("driver");//抽取数据
            String url=pro.getProperty("url");
            String username=pro.getProperty("username");
            String password=pro.getProperty("password");

            //接下来这部分，开始链接数据库
            //装载驱动器名称
            Class.forName(driver);
            //conn被赋值 用来做链接
            conn = DriverManager.getConnection(url,username,password);
            //接着先测试链接情况 TestConn

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //conn在这里被返回
    public static Connection getConn(){
        return  conn;
    }

}