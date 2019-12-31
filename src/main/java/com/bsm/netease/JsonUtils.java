package com.bsm.netease;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import javax.xml.bind.JAXBException;
import java.util.List;
import java.util.Map;

/**
 * json转换工具
 */
public class JsonUtils {
    /**
     * JSON String 转化为Bean对象
     *
     * @param <T>
     * @param jsonStr
     * @param clazz
     * @return
     * @throws JAXBException
     */
    public static <T> T jsonString2Object(String jsonStr, Class<T> clazz) throws JSONException {
        JSONObject jsonObject = (JSONObject) JSONObject.parse(jsonStr);
        if (jsonObject != null) {
            return JSONObject.parseObject(jsonStr, clazz);
        }
        return null;
    }

    /**
     * json String 转化为JsonObject对象
     *
     * @param jsonStr
     * @return
     * @throws JSONException
     */
    public static JSONObject json2JsonObject(String jsonStr) throws JSONException {
        try {
            return (JSONObject) JSONObject.parse(jsonStr);
        } catch (Exception e) {
            e.printStackTrace();
            throw new JSONException("Json转化为JsonObject对象时发生错误。 " + e.getMessage());
        }
    }

    /**
     * Object 转化为 JSONObject
     *
     * @param object
     * @return
     * @throws JSONException
     */
    public static JSONObject object2JsonObject(Object object) throws JSONException {
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(object);
        return jsonObject;
    }

    /**
     * Object 转化为json string
     *
     * @param object
     * @return
     * @throws JSONException
     */
    public static String objToJsonString(Object object) throws JSONException {
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(object);
        return jsonObject.toJSONString();
    }

    /**
     * 判断是否是json
     *
     * @param content
     * @return
     */
    public static boolean isJson(String content) {
        try {
            JSONObject.parseObject(content);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * json 对象 转换为 map 对象
     *
     * @param jsonObject
     * @return
     */
    public static Map<String, Object> jsonToMap(JSONObject jsonObject) {
        Map<String, Object> map = (Map) jsonObject;
        return map;
    }

    public static JSONObject resultJson(List list, Integer count, Integer size) {
        JSONObject json = new JSONObject();

        int countPage = (count + (size - 1)) / size;
        json.put("list", list);
        json.put("countData", count);
        json.put("countPage", countPage);
        return json;
    }

}
