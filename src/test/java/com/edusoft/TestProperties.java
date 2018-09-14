package com.edusoft;

import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    @Test
    public void test1(){
        Properties pro=new Properties(); //属性
        try {
            pro.load(TestProperties.class.getClassLoader().getResourceAsStream("config/db.properties"));//读取配置文件
        } catch (IOException e) {
            e.printStackTrace();
        }
        String driver=pro.getProperty("driver");//抽取数据
        String url=pro.getProperty("url");
        String username=pro.getProperty("username");
        String password=pro.getProperty("password");
        System.out.println(driver);     //输出返回得到的数据
        System.out.println(url);
        System.out.println(username);       //同上
        System.out.println(password);
    }
}
