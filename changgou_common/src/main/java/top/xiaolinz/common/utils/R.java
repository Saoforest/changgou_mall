package top.xiaolinz.common.utils;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import io.swagger.annotations.ApiModel;
import org.apache.http.HttpStatus;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author XiaoLin
 * @date 2022/3/6 13:56
 * @blog https://www.xiaolinz.top/
 **/

@ApiModel(value = "统一返回封装类")
public class R extends LinkedHashMap<String, Object> {
    private static final long serialVersionUID = 1L;



    private R() {
        put("flag",true);
        put("code", 0);
        put("msg", "success");
    }

    public static R error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static R error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("flag",false);
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }
    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok(Integer code,String msg){
        final R r = new R();
        r.put("code",code);
        r.put("msg",msg);

        return r;
    }

    public static R ok() {
        return new R();
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }


    public Integer getCode(){
        return (Integer)this.get("code");
    }

    public R setData(Object data){
        super.put("data",data);
        return this;
    }

    /**
     * 使用fastjson返回任意类型对象
     */
    public <T> T getData(String key,TypeReference<T> typeReference) {
        // 默认是map类型
        final Object data = this.get(key);

        if (data != null) {
            final String json = JSON.toJSONString(data);
            return JSON.parseObject(json, typeReference);
        }
            return JSON.parseObject("", typeReference);
    }

    /**
     * 使用hutool工具返回任意类型对象
     */
    public <T> T getData(String key,Class<? extends T> type) {
        // 默认是map类型
        final Object data = this.get(key);

        if (data != null) {
            final String json = JSONUtil.toJsonStr(data);
            return JSONUtil.toBean(json,type);
        }
        return JSONUtil.toBean("",type);
    }
}
