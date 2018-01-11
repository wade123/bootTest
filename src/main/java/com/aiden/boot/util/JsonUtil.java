/**
 * BrandBigData.com Inc.
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.aiden.boot.util;

import com.aiden.boot.domain.entity.Country;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.lang.reflect.Field;

/**
 * @author Tim_Yu
 * @version $Id: JsonUtil.java, v0.1 2018/1/10 12:55 Tim_Yu
 */
public class JsonUtil {

    public static String writeObjectAsString(Object object) {
        if (object == null) {
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.createObjectNode();
        Class<?> aClass = object.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            String name = field.getName();
            Object value = null;
            try {
                value = field.get(object);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            objectNode.putPOJO(name, value);
        }
        return objectNode.toString();
    }

    public static void main(String[] args) {
        Country country = new Country();
        String s = JsonUtil.writeObjectAsString(country);
        System.out.println(s);
    }

}
