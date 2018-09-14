package com.edusoft;

import com.edusoft.dto.Category;
import com.edusoft.service.impl.CategoryServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestCategoryServiceImpl {
    //测试服务层的实现，需要调用 服务层的对象, 然后服务层对象自己去调用持久层这样一直测试下去就可以了
    CategoryServiceImpl csi;

    @Before
    //before 是在所有方法之前先执行的方法
    public void init() {
        csi = new CategoryServiceImpl();
    }

    @Test
    //如果有多个test，则按顺序先后做测试
    public void tcsi() throws SQLException {
        Category category = new Category();
        category.setText("1151");
        category.setParent("###");
        System.out.println(csi.add(category));
    }

    @Test
    public void testFindByProp() throws SQLException {
        Map map = new HashMap();
        map.put("text", "零食");
        List<Category> list = csi.findByProp(map);
        //得到结果列表后，遍历输出
        //加一个逻辑判断，防止返回的列表为空
        if (list.size() > 0) {
            for (Category c : list) {
                System.out.println(c.toString());
            }
        } else {
            System.out.println("no data");
        }
    }

    @Test
    //
    public void testUpdate() throws SQLException {
        String id = "20180809150247000";
        Category category=csi.findOneById(id);//通过Id精确查询到要修改的对象
        System.out.println("修改前："+category);
//        更改对象的属性
        category.setText("修改13:24 ");
//        调用服务中的修改功能
        csi.update(category);
        System.out.println("修改后："+category);
    }

    @Test
    public void testfindOneById() throws SQLException {
        String id = "20171101092258010";
        Category category = new Category();
        category.setId(id);
//        category.setParent("###");
//        System.out.println(category);
        System.out.println(csi.findOneById(id));
}

    @Test
    public void testfindOneByProp() throws SQLException {
        Map map = new HashMap();
//        map.put("text","text");
        map.put("id","20171101092258010");
        System.out.println(map);

        Category category = csi.findOneByProp(map);
        System.out.println(category);
    }
}
