package com.avocado.boot.starter.mybatis.basic;

/**
 * @author ：qiaoliang
 */
public class Entity<T> implements java.io.Serializable{

    private T id;

    public Entity() {
    }

    public Entity(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}
