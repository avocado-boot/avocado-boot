package com.avocado.boot.starter.mybatis.service.impl;

import com.avocado.boot.starter.mybatis.basic.BaseEntity;
import com.avocado.boot.starter.mybatis.service.BaseService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author ：qiaoliang
 * @date ：2020-07-21
 */
public class BaseServiceImpl <Mapper extends BaseMapper<Entity>,Entity extends BaseEntity>
        extends ServiceImpl<Mapper,Entity>
        implements BaseService<Entity> {
}
