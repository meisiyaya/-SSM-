package com.edusoft;

import com.edusoft.dao.Db;
import org.junit.Test;


//测试框架不需要main函数。因为@Test 测试方法可以直接运行。而且可以同时测试多个方法
//也不需要new对象。因为静态函数直接调用。这里的单例模式
public class TestConn {
    @Test
    public void testC(){
        System.out.println(Db.getConn());
        //这里输出得到一串值com.mysql.jdbc.JDBC4Connection@4ca8195f。说明数据库链接是可以的。
        //则后面的增删改查都是基于这个链接
    }
}
