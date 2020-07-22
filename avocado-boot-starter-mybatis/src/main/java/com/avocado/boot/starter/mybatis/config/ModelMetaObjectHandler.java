package com.avocado.boot.starter.mybatis.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;
import java.util.Objects;

/**
 * mybatis默认配置
 *
 * @author ：qiaoliang
 * @date ：2020-06-15
 */
public class ModelMetaObjectHandler implements MetaObjectHandler {

    /**创建时间**/
    private static final String CREATE_TIME = "createTime";
    /**修改时间**/
    private static final String UPDATE_TIME = "updateTime";
    @Override
    public void insertFill(MetaObject metaObject) {
        // 获取到需要被填充的字段值
        if(Objects.isNull(getFieldValByName(CREATE_TIME, metaObject))){
            setFieldValByName(CREATE_TIME, new Date(),metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 获取到需要被填充的字段值
        if(Objects.isNull(getFieldValByName(UPDATE_TIME, metaObject))){
            setFieldValByName(UPDATE_TIME, new Date(),metaObject);
        }
    }


}
