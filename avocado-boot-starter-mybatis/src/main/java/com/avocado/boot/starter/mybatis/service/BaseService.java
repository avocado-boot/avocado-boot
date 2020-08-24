package com.avocado.boot.starter.mybatis.service;

import com.avocado.boot.starter.mybatis.basic.BaseEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author ：qiaoliang
 * @date ：2020-07-21
 */
public interface BaseService<Entity extends BaseEntity> extends IService<Entity> {
}
