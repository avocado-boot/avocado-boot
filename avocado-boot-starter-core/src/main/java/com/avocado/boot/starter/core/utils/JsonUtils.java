package com.avocado.boot.starter.core.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.List;

/**
 * Json工具类
 *
 * @author ：qiaoliang
 */
public class JsonUtils {

    private static class JsonMapper extends ObjectMapper {
        JsonMapper(){
            super();
            //  忽略不存在的字段
            this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            //  忽略value为null时，key的输出
            this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            //  禁用对日期以时间戳方式输出的特性
            this.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            this.registerModule(new JavaTimeModule());
            /*
                序列换成json时,将所有的long变成string
                因为js中得数字类型不能包含所有的java long值
             */
            SimpleModule module = new SimpleModule();
            module.addSerializer(Long.class, ToStringSerializer.instance);
            module.addSerializer(Long.TYPE, ToStringSerializer.instance);
            this.registerModule(module);
        }
    }

    private static class Holder {
        private final static ObjectMapper MAPPER = new JsonMapper();
    }


    public static ObjectMapper getInstance(){
        return Holder.MAPPER;
    }

    public static String toJson(Object obj) throws JsonProcessingException{
        return Holder.MAPPER.writeValueAsString(obj);
    }

    public static <T> T toBean(String json, Class<T> clazz) throws JsonProcessingException {
        return Holder.MAPPER.readValue(json, clazz);
    }

    public static <T> List<T> toList(String json, Class<T> clazz) throws JsonProcessingException{
        JavaType javaType = Holder.MAPPER.getTypeFactory().constructParametricType(List.class, clazz);
        return Holder.MAPPER.readValue(json, javaType);
    }

}
