package com.edusoft.dto;

//这里是一个商品基础类
public class Category {
    String id;  //商品分类的编号ID
    String text;    //商品的分类名称
    String parent;  //17位String 类型的数据 商品分类的父类ID

    //接着为商品的属性添加get和set函数，以便在实际操作过程对数据进行存取

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    //接着为了展示对象，我们改写一个toString方法
    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", parent='" + parent + '\'' +
                '}';
    }
}


