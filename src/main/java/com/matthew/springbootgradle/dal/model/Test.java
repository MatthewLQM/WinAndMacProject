package com.matthew.springbootgradle.dal.model;

/**
 * @author zeyuan
 * Create Time : 2019/2/13 11:42 PM
 */
public class Test {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test{id=" + id + ",name=" + name + "}";
    }
}
