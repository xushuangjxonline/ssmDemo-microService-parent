package com.jxonline.sword.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;


import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * json格式转换的工具类
 * @author xs
 * @date 2022/9/15
 **/
public class JsonUtil {

    public static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        //忽略字段不匹配的错误
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    }

    /**
     * 创建ObjectNode
     * @return ObjectNode
     */
    public static ObjectNode creatJson(){
        return objectMapper.createObjectNode();
    }

    /**
     * json字符串转java bean
     * @param  jsonStr
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T jsonStr2Bean(String jsonStr,Class<T> clazz){
        T t = null;
        try {
            t = objectMapper.readValue(jsonStr,clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }


    /**
     * json字符串转 Map
     * @param jsonStr
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> Map<String,Object> jsonStr2Map(String jsonStr, Class<T> clazz) {
        Map<String,Object> map = null;
        try {
            map = objectMapper.readValue(jsonStr, new TypeReference<Map<String,Object>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }


    /**
     * json字符串转 List<Bean>
     * @param jsonStr
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> jsonStr2BeanList(String jsonStr, Class<T> clazz){
        List<T> t = null;
        try {
            t = objectMapper.readValue(jsonStr, new TypeReference<List<T>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }


    /**
     * json字符串转 Bean[]
     * @param jsonStr
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T[] jsonStr2BeanArray(String jsonStr, Class<T> clazz){
        T[] t = null;
        try {
            t = objectMapper.readValue(jsonStr, new TypeReference<T[]>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * json字符串转 JsonNode(json对象)
     * @param jsonStr
     * @return
     */
    public static JsonNode jsonStr2JsonObejct(String jsonStr) {
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonNode;
    }


    /**
     * java bean 或者 Map 或者 JsonNode 转json字符串
     * @param obj
     * @return
     */
    public static String object2JsonStr(Object obj) {
        String json = null;
        try {
            json = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }


    /**
     * java bean 或者 Map  转 JsonNode
     * @param obj
     * @return
     */
    public static JsonNode object2JsonObject(Object obj) {
        JsonNode jsonNode = null;
        try {
            //bean或者map 先转成JsonStr
            String jsonStr = objectMapper.writeValueAsString(obj);
            jsonNode = objectMapper.readTree(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonNode;
    }


    /**
     * jsonNode 转 javabean
     * @param jsonNode
     * @return
     */
    public static <T> T jsonObject2Bean(JsonNode jsonNode, Class<T> clazz) {
        //先转jonstr
        String jsonStr = jsonNode.toString();
        return jsonStr2Bean(jsonStr, clazz);
    }



    /**
     * jsonNode 转 map
     * @param jsonNode
     * @return
     */
    public static <T> Map<String,Object> jsonObject2Map(JsonNode jsonNode, Class<T> clazz) {
        //先转jonstr
        String jsonStr = jsonNode.toString();
        return jsonStr2Map(jsonStr,clazz);
    }



    /**
     * jsonNode 转 List<Bean>
     * @param jsonNode
     * @return
     */
    public static <T> List<T> jsonObject2BeanList(JsonNode jsonNode, Class<T> clazz) {
        //先转jonstr
        String jsonStr = jsonNode.toString();
        return jsonStr2BeanList(jsonStr,clazz);
    }


    /**
     * jsonNode 转 Bean[]
     * @param jsonNode
     * @return
     */
    public static <T> T[] jsonObject2BeanArray(JsonNode jsonNode, Class<T> clazz) {
        //先转jonstr
        String jsonStr = jsonNode.toString();
        return jsonStr2BeanArray(jsonStr,clazz);
    }


}
